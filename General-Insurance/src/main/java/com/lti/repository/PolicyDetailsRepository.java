package com.lti.repository;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

import com.lti.entity1.Policy;

@Repository
public class PolicyDetailsRepository extends GenericRepository {
	
	public Policy fetch(int id) {
		return entityManager.find(Policy.class,id);	
	}
	
	public double calculateIdv(int cid, int did, int vid,String period , LocalDate startDate,String type ) {
		return (Double)
				entityManager
				.createQuery("select d.idv from Depreciation d where d.id= :did")
				.setParameter("did", did)
				.getSingleResult();	
	}
}
