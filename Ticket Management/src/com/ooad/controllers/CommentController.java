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
import com.ooad.models.Comment;



@WebServlet("/comment")
public class CommentController extends HttpServlet{

		private static final long serialVersionUID = 1L;
		
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false);
			Integer fromUser = (Integer) session.getAttribute("userId");
			TicketDao ticketDao = new TicketDaoImpl();
			
			String str = request.getParameter("id");
			
			if (str != null) {
				Integer id = Integer.parseInt(str);
				List<Comment> c=ticketDao.getComments(id);
				session.setAttribute("tid", id);
				request.setAttribute("com",c);
				request.getRequestDispatcher("comment.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("comment.jsp").forward(request, response);
			}
		}	
		
		
		@Override
		protected void doPost(
				HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(false);
			Comment c =new Comment();
			System.out.println(request.getParameterMap());
			Integer usr_id =Integer.parseInt(request.getParameter("userid"));
			Integer ticket_id =Integer.parseInt(request.getParameter("tic_id"));
			String post=request.getParameter("post1");
			TicketDao ticketDao=new TicketDaoImpl();
			System.out.println(post);
			System.out.println("In comment controller post");
			if (usr_id!=null && ticket_id!=null && post!=null) {
					c.setId(ticket_id);
					c.setUser_id(usr_id);
					c.setPost(post);
					ticketDao.postComment(c);
				System.out.println("after post");
					request.setAttribute("successMessage", "Successful");
					request.getRequestDispatcher("comment.jsp").forward(request, response);
				}
			 else {
				request.setAttribute("successMessage", "Error");
				request.getRequestDispatcher("comment.jsp").forward(request, response);
			}
			
			
		}
	
}
