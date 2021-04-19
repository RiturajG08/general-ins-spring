package com.lti.repository;

import org.springframework.stereotype.Repository;

import com.lti.entity1.Customer;

@Repository
public class VehicleRepository extends GenericRepository {

	public boolean isVechiclePresent(String number) {
		return (Long)
				entityManager
				.createQuery("select count(v.id) from Vehicle v where v.number= :num")
				.setParameter("num", number)
				.getSingleResult()== 1 ? true : false;
	}
	
	public Customer findById(int id) {
		return entityManager.find(Customer.class, id);
	}
	
	
}


