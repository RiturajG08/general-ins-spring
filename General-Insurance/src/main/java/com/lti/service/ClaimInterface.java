package com.lti.service;

import java.util.List;

import com.lti.entity1.Claim;

public interface ClaimInterface {

	public int addClaim(int pid, String reason) ;
	public List<Claim> searchClaims();
	public List<Claim> viewClaim(int id);
}
