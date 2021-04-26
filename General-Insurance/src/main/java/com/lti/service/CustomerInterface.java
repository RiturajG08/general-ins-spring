package com.lti.service;

import java.util.List;

import com.lti.entity1.Customer;
import com.lti.entity1.Policy;

public interface CustomerInterface {

	public int register(Customer customer);
	public Customer login(String email, String password);
	public List<Policy> searchPolicy(int id);
}
