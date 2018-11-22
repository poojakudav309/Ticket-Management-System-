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
import com.ooad.models.Login;
import com.ooad.models.Customer;
/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerDao customerDao = new CustomerDaoImpl();
		
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		Login login = new Login(username, pass);
		Customer c = customerDao.validateCustomer(login);
		
		HttpSession session = request.getSession();
		
		if(submitType.equals("login") && c!=null && c.getFirstName()!=null){
			request.setAttribute("message", "Hello "+c.getFirstName());
			session.setAttribute("username", c.getUsername());
			session.setAttribute("userId", c.getId());
			session.setAttribute("userdetails", c);
			request.setAttribute("userdetails", c);
			
			request.getRequestDispatcher("dashbord.jsp").forward(request, response);
		}else if(submitType.equals("register")){
			c.setFirstName(request.getParameter("first_name"));
			c.setUsername(request.getParameter("username"));
			c.setPassword(request.getParameter("password"));
			c.setEmail(request.getParameter("email"));
			c.setGender(request.getParameter("gender"));
			c.setLastName(request.getParameter("last_name"));
			c.setPhone(Integer.parseInt(request.getParameter("phone")));
			c.setRole(request.getParameter("role"));
			c.setTeam(request.getParameter("team"));
			customerDao.register(c);
			request.setAttribute("successMessage", "Registration done, please login!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Data Not Found! Please register!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

}
