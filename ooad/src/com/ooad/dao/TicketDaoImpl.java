/**
 * 
 */
package com.ooad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ooad.models.Comment;
import com.ooad.models.Team;
import com.ooad.models.Ticket;

import db.DbManager;

/**
 * @author ram
 *
 */
public class TicketDaoImpl implements TicketDao {
	
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	public int insertTicket (Ticket t) {
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("insert into tickets "
					+ "(from_user, to_user, description, comments, status, priority, created_at, updated_at, type, is_read)"
					+ " values "
					+ "(?,?,?, null, null, ?, sysdate(), sysdate(), ?, default)");
			ps.setInt(1, t.getFromUser());
			ps.setInt(2, t.getToUser());
			ps.setString(3, t.getDescription());
			ps.setInt(4,  t.getPriority());
			ps.setString(5, t.getType());
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

	@Override
	public List<Ticket> getAllTicketsFrom(int id) {
		List<Ticket> ticket_list=new ArrayList<Ticket>(); 
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();
		try{
			conn = db.getConnection();
			System.out.println("In get all teams before select");
			ps =conn.prepareStatement("select * from tickets where from_user=? order by updated_at desc");
			ps.setInt(1,id);
			System.out.println("In get all tickets after select");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				String description=rs.getString("description");
				 int to_user=rs.getInt("to_user");
				 int t_id=rs.getInt("id");
				String type=rs.getString("type");
				int isread=rs.getInt("is_read");
		
				int priority=rs.getInt("priority");
				Ticket t=new Ticket();
				t.setDescription(description);;
				t.setToUser(to_user);
	
				t.setIsRead(isread);
				t.setId(t_id);
				t.setPriority(priority);
				t.setType(type);
				
				
				ticket_list.add(t);
			}
			System.out.println("after ticket list creation");
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
		return ticket_list;
	}

	@Override
	public List<Ticket> getAllTicketsTo(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<Comment> getComments(int id){
		
		List<Comment> l=new ArrayList<Comment>();
		
		
		
	
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();
		try{
			conn = db.getConnection();
			System.out.println("in comment list");
			ps =conn.prepareStatement("select comments.id,comments.posted_at,comments.post,customer.username from comments join customer on customer.id=comments.user where comments.id=?");
			ps.setInt(1,id);
			System.out.println("In get all tickets after select");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			
				String post=rs.getString("post");
				int t_id=rs.getInt("id");
				String username=rs.getString("username");
				String date=rs.getDate("posted_at").toString();
				String time=rs.getTime("posted_at").toString();
				Comment c=new Comment();
				c.setPost(post);
				c.setId(t_id);
				c.setUsername(username);
				c.setDate(date);
				c.setTime(time);
	
				l.add(c);
			}
			System.out.println("after comment list creation");
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
		
		
		return l;
	}
	
//change the sql query.
	public int  postComment(Comment c){
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("insert into comments values(?,sysdate(),?,?)");
			ps.setInt(1, c.getId());
			//ps.setInt(2, c.);
			ps.setString(3, c.getPost());
			ps.setInt(2,c.getUser_id());
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	
	
	
	public List<Ticket> searchTicket(String x,int y){
		List<Ticket> l=new ArrayList<>();
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from tickets where from_user=? lower(description) like '%?%'");
			ps.setString(2, x);
			ps.setInt(1, y);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()){
				
				//int i=rs.getInt("ticket_id");
				String description=rs.getString("description");
				 int to_user=rs.getInt("to_user");
				//String date=rs.getString("updated_at");
				//String comments=rs.getString("comments");
				String type=rs.getString("type");
				int isread=rs.getInt("is_read");
				//String status=rs.getString("status");
				int priority=rs.getInt("priority");
				Ticket t=new Ticket();
				t.setDescription(description);;
				t.setToUser(to_user);
				//t.setComments(comments);
				t.setIsRead(isread);
				//t.setStatus(status);
				t.setPriority(priority);
				t.setType(type);
				//t.setUpdatedAt(date);
				
				l.add(t);
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return l;
	}
	
	
}
