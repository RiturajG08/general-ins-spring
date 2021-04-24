package com.lti.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.PolicyDto;
import com.lti.dto.PolicyHelperDto;
import com.lti.entity1.Customer;
import com.lti.entity1.Depreciation;
import com.lti.entity1.Policy;
import com.lti.entity1.Vehicle;
import com.lti.repository.PolicyRepository;

@Service
@Transactional
public class PolicyService implements PolicyInterface {
	
	@Autowired
	private PolicyRepository policyRepository;
	

	public int addPolicyToVehicle(Policy policy) {
	Policy updatedPolicy= (Policy) policyRepository.save(policy);
	return updatedPolicy.getId();
	}
}
