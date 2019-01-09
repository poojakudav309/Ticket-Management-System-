package com.ooad.models;

public class TeamLeader extends Employee {
	 private int max_leaves=10;
	 private String subtype="desktopapps";
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
