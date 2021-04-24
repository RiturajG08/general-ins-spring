package com.lti.service;

import java.time.LocalDate;

import com.lti.dto.PolicyHelperDto;
import com.lti.entity1.Policy;

public interface PolicyInterface {

	public int addPolicyToVehicle(Policy policy);
}
