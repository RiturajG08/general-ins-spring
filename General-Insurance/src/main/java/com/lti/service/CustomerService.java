package com.lti.service;


import java.util.Base64;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity1.Customer;
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
		//	String e=customerRepository.fetchEmail(email);
		//	emailService.sendEmailForNewRegistration(e, "LTI Insurance Company", "Welcome To Our Website");
			Customer customer= customerRepository.find(Customer.class, id);
			return customer;
		}
		catch(EmptyResultDataAccessException e) {
			throw new CustomerServiceException("Invalid Email/Password");
		}
	}
}
