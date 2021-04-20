package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.VehicleStatus;
import com.lti.entity1.Policy;
import com.lti.entity1.Vehicle;
import com.lti.exception.VehicleServiceException;
import com.lti.service.PolicyService;

@RestController
@CrossOrigin
public class PolicyController {
	
	@Autowired
	private PolicyService  policyService;
	
	

	
	
}
