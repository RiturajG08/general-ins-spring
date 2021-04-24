package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.PolicyDto;
import com.lti.dto.PolicyHelperDto;
import com.lti.dto.PolicyStatus;
import com.lti.entity1.Policy;
import com.lti.exception.PolicyServiceException;
import com.lti.service.PolicyService;

@RestController
@CrossOrigin
public class PolicyController {
	
	@Autowired
	private PolicyService  policyService;
	
	@PostMapping("/policy")
	public PolicyStatus addPolicy(@RequestBody Policy policy) {
			int id= policyService.addPolicyToVehicle(policy);
			
			PolicyStatus status= new PolicyStatus();
			status.setStatus(true);
			status.setMessage("Policy buyed successfully!");
			status.setPolicyId(id);
			return status;
	}
	
}
