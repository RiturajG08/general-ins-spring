package com.lti.service;

import com.lti.entity1.Claim;

public interface AdminInterface {

	public Claim searchByClaimId(int id, int amount);
	public Claim rejectClaim(int rcid, String rejectionReason);
}
