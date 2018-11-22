package com.ooad.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ooad.dao.TicketDao;
import com.ooad.dao.TicketDaoImpl;

import com.ooad.models.Ticket;

@WebServlet("/ticket")
public class TicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public TicketController() {}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Integer id = (Integer) session.getAttribute("userId");
		System.out.println("In ticket display controller");
		TicketDao ticketDao = new TicketDaoImpl();
		List<Ticket> t=ticketDao.getAllTicketsFrom(id);
		request.setAttribute("list",t);
	
			request.getRequestDispatcher("dashbord.jsp").forward(request, response);
		}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		TicketDao ticketDao = new TicketDaoImpl();
		Ticket t = new Ticket();

		Integer fromUser = (Integer) session.getAttribute("userId");
		String toUser = request.getParameter("to");
		String description = request.getParameter("description");
		String type = request.getParameter("type");
		int priority = (request.getParameter("priority") != null) ? Integer.parseInt(request.getParameter("priority")) : 0;

		if (fromUser != null
				&& toUser != ""
				&& description != ""
				&& type != null) {
						if (fromUser != null
					&& toUser != ""
					&& description != ""
					&& type != null) {
				t.setDescription(description);
				t.setFromUser(fromUser);
				t.setPriority(priority);
				t.setToUser(Integer.parseInt(toUser));
				t.setType(type);
				ticketDao.insertTicket(t);
				request.setAttribute("successMessage", "Successful");
				request.getRequestDispatcher("ticket.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("successMessage", "Error");
			request.getRequestDispatcher("ticket.jsp").forward(request, response);
		}
	}
}
