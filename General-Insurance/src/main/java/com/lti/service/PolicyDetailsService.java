package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity1.Policy;
import com.lti.repository.PolicyDetailsRepository;


@Service
@Transactional
public class PolicyDetailsService {
	
	@Autowired
	private PolicyDetailsRepository policyDetailsRepository;
	
	public Policy get(int id) {
		return policyDetailsRepository.fetch(id);
	}
}
