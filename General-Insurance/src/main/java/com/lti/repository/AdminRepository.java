package com.lti.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity1.Claim;

@Repository
public class AdminRepository extends GenericRepository {
	
	public Claim fetchClaimById(int id) {
		return entityManager.find(Claim.class,id);	
	}
}
