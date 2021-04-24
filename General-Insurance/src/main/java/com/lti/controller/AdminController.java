package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminDto;
import com.lti.dto.AdminStatus;
import com.lti.entity1.Claim;
import com.lti.exception.AdminServiceException;
import com.lti.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {
	

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/approvedClaim")
	public AdminStatus approval(@RequestBody AdminDto adminDto) {
		try {
			Claim claim = adminService.searchByClaimId(adminDto.getId(), adminDto.getAmount(), adminDto.getStatus());
			AdminStatus adminStatus = new AdminStatus();
			adminStatus.setStatus(true);
			adminStatus.setMessage("Claim approved");
			return adminStatus;
			
		}
		catch(AdminServiceException e) {
			AdminStatus adminStatus = new AdminStatus();
			adminStatus.setStatus(false);
			adminStatus.setMessage(e.getMessage());
			return adminStatus;
			
		}
		
		
	}
	
	

}
