package com.ooad.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ooad.dao.TicketDao;
import com.ooad.dao.TicketDaoImpl;

import com.ooad.models.Ticket;
@WebServlet("/display")
public class TicketDisplayController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int id=1;
			String search_str=request.getParameter("search");
			System.out.println("In ticket display controller");
			TicketDao ticketDao = new TicketDaoImpl();
			List<Ticket> t=ticketDao.searchTicket(search_str , id);
			request.setAttribute("list",t);
		
				request.getRequestDispatcher("dashbord.jsp").forward(request, response);
			}

		}

