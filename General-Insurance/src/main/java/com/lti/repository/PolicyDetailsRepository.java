package com.lti.repository;

import org.springframework.stereotype.Repository;

import com.lti.entity1.Policy;

@Repository
public class PolicyDetailsRepository extends GenericRepository {
	
	public Policy fetch(int id) {
		return entityManager.find(Policy.class,id);	
	}
}
