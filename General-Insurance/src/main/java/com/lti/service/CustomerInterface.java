package com.lti.service;

import com.lti.entity1.Customer;

public interface CustomerInterface {

	public int register(Customer customer);
	public Customer login(String email, String password);
}
