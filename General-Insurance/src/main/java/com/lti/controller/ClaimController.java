package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ClaimDto;
import com.lti.dto.ClaimStatus;
import com.lti.entity1.Claim;
import com.lti.service.ClaimService;
import com.lti.service.CustomerService;
import com.lti.service.EmailService;

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
	
	@GetMapping("/searchAllClaims")
	public List<Claim> getAllClaims() {
		return claimService.searchClaims();
	}
	
	@GetMapping("/viewuserclaim")
	public List<Claim> viewUserClaim(int id) {
		return claimService.viewClaim(id);
	}
	
}
