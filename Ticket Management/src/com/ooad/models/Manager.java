package com.ooad.models;

public class Manager extends Employee {
	private int max_leaves=20;
	private String subtype="nmt";

	@Override
	public void raiseTicket(Customer c, Ticket t) {
		if(t.getNo_days()<= max_leaves || t.getSubtype().equals(subtype)){
			t.setToUser(sv.getId());
		} else {
			sv.setNext(custDao.getCustObj(c.getSupervisor()));
			sv.raiseTicket(sv, t);
		}
	}

}
