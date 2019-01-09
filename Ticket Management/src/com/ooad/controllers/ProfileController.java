package com.ooad.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ooad.dao.CustomerDao;
import com.ooad.dao.CustomerDaoImpl;
import com.ooad.models.Customer;

@WebServlet("/updateProfile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		Customer c = new Customer();
		CustomerDao customerDao = new CustomerDaoImpl();
		Customer c1 = (Customer) session.getAttribute("userdetails");
		
		Integer id = (Integer) session.getAttribute("userId");
		if (id != null) {
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String email = request.getParameter("email");
			int phone = Integer.parseInt(request.getParameter("phone"));
			String role=request.getParameter("role");
			String gender=request.getParameter("gender");
			String password=request.getParameter("password");
			
			c.setId(id);
			c.setFirstName(firstName);
			c.setLastName(lastName);
			c.setEmail(email);
			c.setPhone(phone);
			c.setRole(role);
			c.setGender(gender);
			c.setPassword(password);
		
			customerDao.updateProfile(c);
			c1.setId(id);
			c1.setFirstName(firstName);
			c1.setLastName(lastName);
			c1.setEmail(email);
			c1.setPhone(phone);
			c1.setRole(role);
			c1.setGender(gender);
			c1.setPassword(password);
		
			session.setAttribute("userdetails", c1);
			request.setAttribute("successMessage", "Profile Updated!");
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Data Not Found! Please register!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
}
