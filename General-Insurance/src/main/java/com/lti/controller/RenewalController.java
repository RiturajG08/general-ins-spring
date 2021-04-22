package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.lti.dto.Renewal;
import com.lti.dto.RenewalBuyPolicy;
import com.lti.dto.RenewalStatus;
import com.lti.entity1.Policy;
import com.lti.exception.RenewalServiceException;
import com.lti.service.RenewalService;

@RestController
@CrossOrigin

public class RenewalController {
	
	@Autowired
	private RenewalService renewalService;

	@PostMapping("/renewal")
	public RenewalStatus renewPolicy(@RequestBody Renewal renewal) {
		try {
		Policy Policy = renewalService.login(renewal.getId());
			RenewalStatus renewalStatus = new RenewalStatus();
			renewalStatus.setStatus(true);
			renewalStatus.setMessage("policy valid");
			renewalStatus.setPolicyId(renewal.getId());
			return renewalStatus;
		}
		catch(RenewalServiceException e) {
			RenewalStatus renewalStatus = new RenewalStatus();
			renewalStatus.setStatus(true);
			renewalStatus.setMessage(e.getMessage());		
			return renewalStatus;
		}
	}
	
	@PostMapping("/renewalbuypolicy")
	public RenewalStatus renewBuyPolicy(@RequestBody RenewalBuyPolicy renewalBuyPolicy) {
	/*	try {
		Policy Policy = renewalService.login(renewal.getId());
			RenewalStatus renewalStatus = new RenewalStatus();
			renewalStatus.setStatus(true);
			renewalStatus.setMessage("Please enter vaild vehicle number");
			renewalStatus.setPolicyId(renewal.getId());
			return renewalStatus;
		}
		catch(RenewalServiceException e) {
			RenewalStatus renewalStatus = new RenewalStatus();
			renewalStatus.setStatus(true);
			renewalStatus.setMessage(e.getMessage());		
			return renewalStatus;
		} */
		return null;
	}
}
