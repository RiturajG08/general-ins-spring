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
import com.lti.entity1.Policy;
import com.lti.service.PolicyDetailsService;

@RestController
@CrossOrigin
public class PolicyDetailsController {
	
	@Autowired
	private PolicyDetailsService pds;
	
	/*@GetMapping("/searchPolicy")
	public Policy search(@RequestParam("id") int id) {
		Policy policy = pds.get(id);
		return policy;	
	}*/
	
	@PostMapping("/searchPolicy")
	public PolicyDetailsStatus search(@RequestBody PolicyDetailsDto policyDetailsDto) {
		Policy policy = pds.get(policyDetailsDto.getPid());
		PolicyDetailsStatus policyDetailsStatus = new PolicyDetailsStatus();
		policyDetailsStatus.setPolicyNumber(policy.getId());
		policyDetailsStatus.setStartDate(policy.getPolicyStartDate());
		policyDetailsStatus.setEndDate(policy.getPolicyEndDate());
		policyDetailsStatus.setIdv(policy.getEachYearIdv());
		policyDetailsStatus.setPremium(policy.getPremium());
		policyDetailsStatus.setTotalIdv(policy.getTotalIdv());
		
		return policyDetailsStatus;	
	}
}
