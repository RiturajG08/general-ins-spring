package com.lti.repository;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

@Repository
public class DepreciationRepository extends GenericRepository {

	public int fetchVhehiclePrice(int id) {
		return (Integer)
				entityManager
				.createQuery("select v.price from Vehicle v where v.id = :vid ")
				.setParameter("vid", id)
				.getSingleResult();
	}
	
	//select c from Customer c where EXTRACT(year from c.dateOfBirth)=:dt
	public LocalDate fetchVehicleAge(int id) {
		return (LocalDate)
				entityManager
				.createQuery("select v.registrationDate from Vehicle v where v.id= :vid")
				.setParameter("vid", id)
				.getSingleResult();
		
		
	}
}