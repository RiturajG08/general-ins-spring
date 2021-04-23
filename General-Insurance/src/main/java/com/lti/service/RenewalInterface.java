package com.lti.service;

import com.lti.entity1.Policy;

public interface RenewalInterface {

	public Policy checkPolicyNumber(int id);
	public Policy renewOldPolicy(int pid, String number, String type, String period);
}
