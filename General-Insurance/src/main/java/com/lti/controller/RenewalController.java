package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.FinalRenewalStatus;
import com.lti.dto.PolicyDetailsDto;
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
		Policy Policy = renewalService.checkPolicyNumber(renewal.getId());
			RenewalStatus renewalStatus = new RenewalStatus();
			renewalStatus.setStatus(true);
			renewalStatus.setMessage("policy valid");
			renewalStatus.setPolicyId(renewal.getId());
			return renewalStatus;
		}
		catch(RenewalServiceException e) {
			RenewalStatus renewalStatus = new RenewalStatus();
			renewalStatus.setStatus(false);
			renewalStatus.setMessage(e.getMessage());		
			return renewalStatus;
		}
	}
	
	@PostMapping("/renewalpolicy")
	public RenewalStatus renewPolicy(@RequestBody RenewalBuyPolicy renewalBuyPolicy) {
		try {
		PolicyDetailsDto policyDetailsDto = renewalService.renewOldPolicy(renewalBuyPolicy.getPid(),renewalBuyPolicy.getNumber(), renewalBuyPolicy.getType(), renewalBuyPolicy.getPeriod());
			RenewalStatus renewalStatus = new RenewalStatus();
			
		    renewalStatus.setEndDate(policyDetailsDto.getEndDate());
		    renewalStatus.setStartDate(policyDetailsDto.getStartDate());
		    renewalStatus.setPremium(policyDetailsDto.getPremium());
		    renewalStatus.setIdv(policyDetailsDto.getEachYearIdv());
		    renewalStatus.setTotalIdv(policyDetailsDto.getTotalIdv());
		    renewalStatus.setType(policyDetailsDto.getPolicyType());
		    
			return renewalStatus;
		}
		catch(RenewalServiceException e) {
			RenewalStatus renewalStatus = new RenewalStatus();
			renewalStatus.setStatus(false);
			renewalStatus.setMessage(e.getMessage());		
			return renewalStatus;
		} 	
	} 
	
	@PostMapping("/renewalPayment")
	public FinalRenewalStatus FinalRenewPolicy(@RequestBody Policy policy ) {
		try {
			int id =renewalService.saveRenewalPolicy(policy.getId(), policy.getEachYearIdv(),policy.getPremium(),policy.getTotalIdv(),policy.getPolicyStartDate(),policy.getPolicyEndDate(),policy.getPeriod(),policy.getType());
			FinalRenewalStatus finalRenewalStatus = new FinalRenewalStatus();
			
			finalRenewalStatus.setId(id);
			finalRenewalStatus.setStatus(true);
			finalRenewalStatus.setMessage("renewal success");
			return finalRenewalStatus;
		}
		catch(RenewalServiceException e) {
            FinalRenewalStatus finalRenewalStatus = new FinalRenewalStatus();
			finalRenewalStatus.setStatus(false);	
			return finalRenewalStatus;
		} 	
	}
	
	
}
