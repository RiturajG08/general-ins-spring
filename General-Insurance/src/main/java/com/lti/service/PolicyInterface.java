package com.lti.service;

import java.time.LocalDate;

public interface PolicyInterface {

	public int addPolicyToVehicle(int cid, int did, int vid, String period , LocalDate startDate, String type);
}
