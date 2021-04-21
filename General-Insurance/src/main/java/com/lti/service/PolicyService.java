package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity1.Policy;
import com.lti.entity1.Vehicle;
import com.lti.exception.VehicleServiceException;
import com.lti.repository.PolicyRepository;

@Service
@Transactional
public class PolicyService {
	
	@Autowired
	private PolicyRepository policyRepository;
	
	public int addPolicy(Policy policy) {
		/*double idv= policyRepository.calculateIdv(id);
		double premium= idv*0.05;

		policy.setIdv(idv);
		policy.setPremium(premium);
		
		policyRepository.save(policy);
		
		return policy;*/
	
		
		Policy updatedPolicy= (Policy) policyRepository.save(policy);
		return updatedPolicy.getId();
		
	}

}
