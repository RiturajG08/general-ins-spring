package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.PolicyDetailsDto;
import com.lti.dto.PolicyDetailsStatus;
import com.lti.dto.PolicyDto;
import com.lti.dto.PolicyStatus;
import com.lti.entity1.Policy;
import com.lti.exception.PolicyServiceException;
import com.lti.service.PolicyDetailsService;

@RestController
@CrossOrigin
public class PolicyDetailsController {
	
	@Autowired
	private PolicyDetailsService policyDetailsService;
	
	
	@PostMapping("/policydetails")
	public PolicyDetailsStatus search(@RequestBody PolicyDto policyDto) {
			PolicyDetailsDto policyDetailsDto= policyDetailsService.addPolicyToVehicle(policyDto.getCid(), policyDto.getDid(), policyDto.getVid(), policyDto.getPeriod(), policyDto.getType());
			
			PolicyDetailsStatus status= new PolicyDetailsStatus();
			status.setIdv(policyDetailsDto.getEachYearIdv());
			status.setTotalIdv(policyDetailsDto.getTotalIdv());
			status.setStartDate(policyDetailsDto.getStartDate());
			status.setEndDate(policyDetailsDto.getEndDate());
			status.setPremium(policyDetailsDto.getPremium());
			status.setType(policyDetailsDto.getPolicyType());
			status.setPeriod(policyDto.getPeriod());
			return status;
	}
}
