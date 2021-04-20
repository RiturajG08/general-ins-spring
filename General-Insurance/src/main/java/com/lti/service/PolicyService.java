package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.repository.PolicyRepository;

@Service
@Transactional
public class PolicyService {
	
	@Autowired
	private PolicyRepository policyRepository;
	
	/*public Policy addPolicy() {
		
	}*/

}
