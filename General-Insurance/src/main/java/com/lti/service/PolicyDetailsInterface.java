package com.lti.service;

import java.time.LocalDate;

import com.lti.dto.PolicyDetailsDto;
import com.lti.entity1.Policy;

public interface PolicyDetailsInterface {
	public PolicyDetailsDto addPolicyToVehicle(int cid, int did, int vid, String period , LocalDate startDate, String type);

}
