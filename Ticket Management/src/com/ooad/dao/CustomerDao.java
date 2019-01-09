package com.ooad.dao;

import com.ooad.models.Customer;
import com.ooad.models.Login;
/**
 * 
 * @author mehra
 * The methods that we need to save and retrieve data from the database
 */
public interface CustomerDao {

	/**
	 * 
	 * @param c
	 * @return
	 */
	public int register(Customer c);
	
	/*
	 * Retrieve the Customer object from the database
	 */
	public Customer validateCustomer(Login login);

	
	//public Customer getCustomer(String username, String pass); This method does not needed as we have the Login object
	public int updateProfile(Customer cust);
	public Customer getCustObj(int id);
}

