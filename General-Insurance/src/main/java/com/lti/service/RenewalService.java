package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity1.Policy;
import com.lti.repository.RenewalRepository;

@Service
@Transactional
public class RenewalService {
	
	@Autowired
	private RenewalRepository renewalRepository;
	
	public int checkPolicy(Policy policy) {
	/*	if(renewalRepository.isPolicyPresent(policy.id)) {
		return 0;
		}
		else {
			throw new PolicyServiceException("Please enter valid id");
		} */
		return 0;
	} 

}
