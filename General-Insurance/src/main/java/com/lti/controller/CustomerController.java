package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Login;
import com.lti.dto.LoginStatus;
import com.lti.dto.RegisterStatus;
import com.lti.entity1.Claim;
import com.lti.entity1.Customer;
import com.lti.entity1.Policy;
import com.lti.exception.CustomerServiceException;
import com.lti.service.CustomerService;
import com.lti.service.EmailService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/register")
	public RegisterStatus register(@RequestBody Customer customer ) {
		try {
			int id= customerService.register(customer);
			//emailService.sendEmailForNewRegistration(customer.getEmail(), "Weclcome", "welcome");
			RegisterStatus status= new RegisterStatus();
			status.setStatus(true);
			status.setMessage("Registration Successfull");
			status.setRegisteredCustomerId(id);
			return status;
		}
		catch(CustomerServiceException e) {
			RegisterStatus status= new RegisterStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/login")
	public LoginStatus login(@RequestBody Login login) {
		try {
			Customer customer = customerService.login(login.getEmail(), login.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(true);
			loginStatus.setMessage("Login successful!");
			loginStatus.setCustomerId(customer.getId());
			loginStatus.setName(customer.getName());
			return loginStatus;
		}
		catch(CustomerServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(false);
			loginStatus.setMessage(e.getMessage());		
			return loginStatus;
		}
	}
	
	@GetMapping("/searchuserpolicy")
	public List<Policy> getUserPolicy(@RequestParam("id") int id) {
		return customerService.searchPolicy(id);
	}
}
