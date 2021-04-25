package com.lti.repository;

import org.springframework.stereotype.Repository;

import com.lti.entity1.Claim;


import java.util.List;

@Repository
public class ClaimRepository extends GenericRepository {
	
	public List<Claim> searchAllClaims() {
		return entityManager.createQuery("select cl.id, cl.claimDate, cl.reason, cl.status from Claim cl")
				.getResultList();			
	}
}
