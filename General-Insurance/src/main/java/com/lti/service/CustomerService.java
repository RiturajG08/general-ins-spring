package com.lti.service;

import java.util.Base64;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity1.Claim;
import com.lti.entity1.Customer;
import com.lti.entity1.Policy;
import com.lti.exception.CustomerServiceException;
import com.lti.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService implements CustomerInterface {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmailService emailService;
	
	public int register(Customer customer) {
		if(customerRepository.isCustomerPresent(customer.getEmail())) {
			throw new CustomerServiceException("customer already registered !");
		}
		else {
			customer.setPassword(Base64.getEncoder().encodeToString(customer.getPassword().getBytes()));
			Customer updatedCustomer= (Customer) customerRepository.save(customer);
			return updatedCustomer.getId();
		}
	}
	
	public Customer login(String email, String password) {
		try {
			password= Base64.getEncoder().encodeToString(password.getBytes());
			int id= customerRepository.fetchByEmailAndPassword(email, password);
			Customer customer= customerRepository.find(Customer.class, id);
			return customer;
		}
		catch(EmptyResultDataAccessException e) {
			throw new CustomerServiceException("Invalid Email/Password");
		}
	}
	
	public List<Policy> searchPolicy(int id){
			return customerRepository.searchPolicyByCustomer(id);	
	}
	
}
