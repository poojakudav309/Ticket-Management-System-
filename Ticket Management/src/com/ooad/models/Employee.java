package com.ooad.models;

import com.ooad.dao.CustomerDao;
import com.ooad.dao.CustomerDaoImpl;

public abstract class Employee {
	protected Customer sv;
	CustomerDao custDao = new CustomerDaoImpl();
	
	public void setNext(Customer c){
		System.out.println("Employee: " + c.getId());
		System.out.println("Employee: " + c.getSupervisor());
		this.sv = custDao.getCustObj(c.getSupervisor());
		System.out.println("Employee: " + sv.getId());
	}
	
	public abstract void raiseTicket(Customer sv, Ticket t);
}
