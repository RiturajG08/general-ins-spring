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
	/*public int fetchVehicleAge(int id, int registrationDate) {
		return (Integer)
				entityManager
				.createQuery("select v from Vehicle v where EXTRACT(year from v.registrationDate) where v.id =:vid and v.registrationDate = :rd")
				.setParameter("vid", id)
				.setParameter("rd", registrationDate)
				.getSingleResult();
		
		
	}*/
}