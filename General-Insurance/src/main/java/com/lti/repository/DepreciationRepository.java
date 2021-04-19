package com.lti.repository;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

@Repository
public class DepreciationRepository extends GenericRepository {

	public int fetchVehiclePrice(int id) {
		return (Integer)
				entityManager
				.createQuery("select v.price from Vehicle v where v.id = :vid ")
				.setParameter("vid", id)
				.getSingleResult();
	}
	
	public LocalDate fetchVehicleAge(int id) {
		return (LocalDate)
				entityManager
				.createQuery("select v.registrationDate from Vehicle v where v.id= :vid")
				.setParameter("vid", id)
				.getSingleResult();
		
		
	}
	
}