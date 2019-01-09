package com.ooad.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ooad.dao.TicketDao;
import com.ooad.dao.TicketDaoImpl;

import com.ooad.models.Ticket;
@WebServlet("/TicketDisplayController")
public class TicketDisplayController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Map<String,List<Ticket>> h=new HashMap<>();
			HttpSession session = request.getSession(false);
			Integer id = (Integer) session.getAttribute("userId");
			System.out.println("In ticket display controller");
			TicketDao ticketDao = new TicketDaoImpl();
			List<Ticket> t=ticketDao.getAllTicketsFrom(id, null);
			h.put("raised_by_me",t);
			List<Ticket> t2=ticketDao.getAllTicketsTo(id, null);
			h.put("assigned_to_me",t2);
			List<Ticket> t3=ticketDao.getAllClosedTickets(id, null);
			h.put("closed",t3);
			List<Ticket> t4=ticketDao.getAllClosedTicketsByMe(id, null);
			h.put("closedbyme",t4);
			request.setAttribute("object",h);
		
				request.getRequestDispatcher("dashbord.jsp").forward(request, response);
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Map<String,List<Ticket>> h=new HashMap<>();
			HttpSession session = request.getSession(false);
			Integer id = (Integer) session.getAttribute("userId");
			String str = request.getParameter("search");
			System.out.println("In ticket display controller");
			TicketDao ticketDao = new TicketDaoImpl();
			
			if (str != null) {
				List<Ticket> t=ticketDao.getAllTicketsFrom(id, str);
				h.put("raised_by_me",t);
				List<Ticket> t2=ticketDao.getAllTicketsTo(id, str);
				h.put("assigned_to_me",t2);
				List<Ticket> t3=ticketDao.getAllClosedTickets(id, str);
				h.put("closed",t3);
				List<Ticket> t4=ticketDao.getAllClosedTicketsByMe(id, str);
				h.put("closedbyme",t4);
				request.setAttribute("object",h);
			
				request.getRequestDispatcher("display.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("dashbord.jsp").forward(request, response);
			}
		}

}

