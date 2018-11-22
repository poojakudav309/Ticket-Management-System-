package com.ooad.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ooad.dao.TeamDao;
import com.ooad.dao.TeamDaoImpl;
import com.ooad.models.Team;
@WebServlet("/TeamController")
public class TeamController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		System.out.println("In team controller");
		TeamDao teamDao=new TeamDaoImpl();
		List<Team> t=teamDao.getAllTeams();
		request.setAttribute("list",t);
		request.getRequestDispatcher("ticket.jsp").forward(request, response);
		
	}
}
