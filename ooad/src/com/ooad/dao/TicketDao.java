package com.ooad.dao;

import java.util.List;

import com.ooad.models.Comment;
import com.ooad.models.Ticket;


public interface TicketDao {
	public int insertTicket(Ticket t);
	public List<Ticket> getAllTicketsFrom(int id);
	public List<Ticket> getAllTicketsTo(String id);
	//public List<Ticket> searchTicket(String x,int id);
	public List<Comment> getComments(int id);
	public int postComment(Comment c);
}
