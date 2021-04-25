package com.lti.service;

import com.lti.dto.PolicyDetailsDto;
import com.lti.entity1.Policy;

public interface RenewalInterface {

	public Policy checkPolicyNumber(int id);
	public PolicyDetailsDto renewOldPolicy(int pid, String number, String type, String period);
}
