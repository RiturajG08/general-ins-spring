package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PolicyRepository extends GenericRepository{
	
	public boolean isVehicleAlreadyInsured(int id) {
		return (Long)
				entityManager
				.createQuery("select count(v.id) from Vehicle v where v.id= :id")
				.setParameter("id", id)
				.getSingleResult()== 1 ? true : false;
	}
	
	public double calculateIdv(int did) {
		return (Double)
				entityManager
				.createQuery("select d.idv from Depreciation d where d.id= :did")
				.setParameter("did", did)
				.getSingleResult();
		
		
	}
	
	
	
}
