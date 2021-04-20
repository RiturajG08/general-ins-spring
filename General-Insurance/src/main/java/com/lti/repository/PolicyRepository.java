package com.lti.repository;

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
	
	
	
}
