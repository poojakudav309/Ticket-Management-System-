package com.ooad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ooad.models.Customer;
import com.ooad.models.Login;

import db.DbManager;




public class CustomerDaoImpl implements CustomerDao {

	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	@Override
	public int register(Customer c) {
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("insert into customer (first_name, last_name, email, phone, role, username, password, team, gender) values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getEmail());
			ps.setInt(4, c.getPhone());
			ps.setString(5, c.getRole());
			ps.setString(6, c.getUsername());
			ps.setString(7, c.getPassword());
			ps.setString(8, c.getTeam());
			ps.setString(9, c.getGender());
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

	@Override
	public Customer validateCustomer(Login login) {
		Customer c = new Customer();
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from customer where username=? and password=?");
			
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());

			ResultSet rs = ps.executeQuery();

			rs.next();
			c.setId(rs.getInt(1));
			c.setFirstName(rs.getString(2));
			c.setLastName(rs.getString(3));
			c.setUsername(rs.getString(7));
			c.setEmail(rs.getString(4));
			c.setRole(rs.getString(6));
			c.setTeam(rs.getString(9));
			c.setGender(rs.getString(10));
			c.setPhone(rs.getInt(5));
			c.setSupervisor(rs.getInt(11));
			
			
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return c;
	}
	
	public Customer getCustObj(int id) {
		Customer c = new Customer();
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("select * from customer where id = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			c.setId(rs.getInt(1));
			c.setFirstName(rs.getString(2));
			c.setLastName(rs.getString(3));
			c.setUsername(rs.getString(7));
			c.setEmail(rs.getString(4));
			c.setRole(rs.getString(6));
			c.setTeam(rs.getString(9));
			c.setGender(rs.getString(10));
			c.setPhone(rs.getInt(5));
			c.setSupervisor(rs.getInt(11));
			
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
		return c;
	}
	
	
	@Override
	public int updateProfile(Customer cust){
		int status = 0;
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("update customer set first_name= ?, last_name= ?, email= ?, phone= ? ,gender=?,role=?,password=? WHERE id = ?");

			ps.setString(1, cust.getFirstName());
			ps.setString(2, cust.getLastName());
			ps.setString(3, cust.getEmail());
			ps.setInt(4, cust.getPhone());
			ps.setInt(8, cust.getId());
			ps.setString(5,cust.getGender() );
			ps.setString(6,cust.getRole() );
			ps.setString(7,cust.getPassword() );
			
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
		return status;
		
	}

}
