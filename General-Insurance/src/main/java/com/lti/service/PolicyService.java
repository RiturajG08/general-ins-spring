package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.PolicyDto;
import com.lti.entity1.Policy;
import com.lti.repository.PolicyRepository;

@Service
@Transactional
public class PolicyService {
	
	@Autowired
	private PolicyRepository policyRepository;
	

	public int addPolicyToVehicle(int id) {
		PolicyDto policyDto= new PolicyDto();
		double idv=  policyRepository.calculateIdv(id);
		double premium= idv*0.05;
		
		Policy policy = new Policy();
		policy.setIdv(idv);
		policy.setPremium(premium);
		policy.setType(policyDto.getType());
		policy.setPolicyStartDate(policyDto.getStartDate());
		
		Policy updatedPolicy= (Policy) policyRepository.save(policy);
		return updatedPolicy.getId();
	}
}
