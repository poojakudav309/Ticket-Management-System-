package com.ooad.models;

import com.ooad.dao.CustomerDao;
import com.ooad.dao.CustomerDaoImpl;

/**
 * 
 * @author mehra
 *
 */
public class Customer extends Employee {

	protected int max_leaves = 0;
	protected String subtype = "packages";
	
	CustomerDao custDao = new CustomerDaoImpl();
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int phone;
	private String role;
	private String team;
	private String gender;
	private int id;
	private int supervisor;
	
	public int getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(int supervisor) {
		this.supervisor = supervisor;
	}

	public int getId () {
		return this.id;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public void raiseTicket(Customer c, Ticket t) {
		// TODO Auto-generated method stub
		System.out.println("104");
		System.out.println(t.getType());
		System.out.println(t.getSubtype());
		if(t.getType().equals("hr")){
			if(t.getNo_days()<= max_leaves){
				//assign
				System.out.println("108");
				t.setToUser(sv.getId());
			} else {
				System.out.println("111");
				sv.setNext(custDao.getCustObj(c.getSupervisor()));
				sv.raiseTicket(sv, t);
			}
		} else if(t.getType().equals("it")){
			if(t.getSubtype().equals(subtype)){
				//assign
				System.out.println("118");
				System.out.println(sv.getId());
				t.setToUser(sv.getId());
				System.out.println("t-touser:"+t.getToUser());
			}
			else{
				System.out.println("122");
				sv.setNext(custDao.getCustObj(c.getSupervisor()));
				sv.raiseTicket(sv, t);
			}
		}
	}
}
