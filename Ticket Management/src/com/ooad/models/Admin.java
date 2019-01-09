package com.ooad.models;

public class Admin extends Employee{
	private int max_leaves=30;
	private String subtype="other";
	
	@Override
	public void raiseTicket(Customer c, Ticket t) {
		if(t.getNo_days()<= max_leaves || t.getSubtype().equals(subtype)){
			t.setToUser(c.getId());
		}
	}
}