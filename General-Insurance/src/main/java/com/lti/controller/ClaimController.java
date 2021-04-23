package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ClaimDto;
import com.lti.dto.ClaimStatus;
import com.lti.service.ClaimService;
import com.lti.service.CustomerService;

@RestController
@CrossOrigin
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	@PostMapping("/claim")
	public ClaimStatus addClaim(@RequestBody ClaimDto claimDto) {
		
		int id = claimService.addClaim(claimDto.getPid(), claimDto.getReason());
		ClaimStatus claimStatus = new ClaimStatus();
		claimStatus.setMessage("Claim request sent for Admin approval");
		claimStatus.setStatus(true);
		claimStatus.setClaimId(id);
		return claimStatus;
	}

}