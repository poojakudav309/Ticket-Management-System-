package com.ooad.dao;

import java.util.List;

import com.ooad.models.Comment;
import com.ooad.models.Ticket;


public interface TicketDao {
	public int insertTicket(Ticket t);
	public List<Ticket> getAllTicketsFrom(int id, String str);
	//public List<Ticket> searchTicket(String x,int id);
	public List<Ticket> getAllTicketsTo(int id, String str);
	public List<Comment> getComments(int id);
	public int postComment(Comment c);
	public int updateTicketStatus(Integer fromUser, Integer tic, String action);
	public List<Ticket> getAllClosedTickets(int id, String str);
	public List<Ticket> getAllClosedTicketsByMe(int id, String str);
}
