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
	
	public int isClaimPresent(int id) {
		return (Integer)
				entityManager
				.createQuery("select c.id from Claim c where c.id= :cid")
				.setParameter("cid", id)
				.getSingleResult();
	}
	
	public List<Claim> viewUserClaim(int id) {
		return entityManager.createQuery("select c.id, c.status, c.amount, c.rejectionReason, c.claimDate from Claim c where c.id=:id")
				.setParameter("id", id)
				.getResultList();			
	}
	
}
