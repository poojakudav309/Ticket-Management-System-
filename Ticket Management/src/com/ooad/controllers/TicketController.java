package com.ooad.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ooad.dao.TicketDao;
import com.ooad.dao.TicketDaoImpl;
import com.ooad.models.Customer;
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
		List<Ticket> t=ticketDao.getAllTicketsFrom(id, null);
		request.setAttribute("list",t);
	
			request.getRequestDispatcher("dashbord.jsp").forward(request, response);
		}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Customer c = (Customer)session.getAttribute("userdetails");
		TicketDao ticketDao = new TicketDaoImpl();
		Ticket t = new Ticket();

		Integer fromUser = (Integer) session.getAttribute("userId");
		//String toUser = request.getParameter("to");
		String description = request.getParameter("description");
		String type = request.getParameter("category1");
		String subType = request.getParameter("category3");
		int priority = (request.getParameter("priority") != null) ? Integer.parseInt(request.getParameter("priority")) : 0;

		if (fromUser != null
				//&& toUser != ""
				&& description != ""
				&& type != null) {
						if (fromUser != null
					//&& toUser != ""
					&& description != ""
					&& type != null) {
				t.setDescription(description);
				t.setFromUser(fromUser);
				t.setPriority(priority);
				//t.setToUser(Integer.parseInt(toUser));
				t.setType(type);
				t.setSubtype(subType);
				c.setNext(c);
				
				c.raiseTicket(c, t);
				System.out.println("after setting sup");
				System.out.println(t.getToUser());
				ticketDao.insertTicket(t);
				request.setAttribute("successMessage", "Successful");
				request.getRequestDispatcher("ticket.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("successMessage", "Error");
			request.getRequestDispatcher("ticket.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Integer fromUser = (Integer) session.getAttribute("userId");
//		String action = request.getParameter("action");
//		Integer tid = Integer.parseInt(request.getParameter("tic_id"));
		TicketDao ticketDao = new TicketDaoImpl();
		InputStream is = request.getInputStream();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buf = new byte[32];
        int r=0;
        while( r >= 0 ) {
            r = is.read(buf);
            if( r >= 0 ) os.write(buf, 0, r);
        }
        String s = new String(os.toByteArray(), "UTF-8");
        String decoded = URLDecoder.decode(s, "UTF-8");
//        System.err.println(">>>>>>>>>>>>> DECODED: " + decoded);
        
        String[] temp = decoded.split("&");
        Integer tid = Integer.parseInt(temp[0].split("=")[1]);
        String action = temp[1].split("=")[1];
		
        System.out.println(fromUser);
		System.out.println(action);
		System.out.println(tid);
		
		ticketDao.updateTicketStatus(fromUser,tid ,action);
	}
}
