package com.lti.repository;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

@Repository
public class RenewalRepository extends GenericRepository{

	public int fetchByPolicyId(int id) {
		return (Integer)
				entityManager
				.createQuery("select p.id from Policy p where p.id= :pid")
				.setParameter("pid", id)
				.getSingleResult();
	}
	
	public LocalDate fetchEndDateOfPolicy(int pid) {
		return (LocalDate)
				entityManager
				.createQuery("select p.policyEndDate from Policy p where p.id= :pid")
				.setParameter("pid", pid)
				.getSingleResult();
    }
	
	public LocalDate fetchStartDateOfPolicy(int pid) {
		return (LocalDate)
				entityManager
				.createQuery("select p.policyStartDate from Policy p where p.id= :pid")
				.setParameter("pid", pid)
				.getSingleResult();
    }
	
	
	
	public LocalDate fetchVehicleRegistartionDate(int pid, String number, String type) {
		return (LocalDate)
				entityManager
				.createQuery(" select  v.registrationDate from Vehicle v where v.number= :vnumber")
				.setParameter("vnumber", number)
				.getSingleResult();
    }
	
	public int fetchVehiclePrice(int pid, String number, String type) {
		return (int)
				entityManager
				.createQuery(" select  v.price from Vehicle v where v.number= :vnumber")
				.setParameter("vnumber", number)
				.getSingleResult();
	}
	
	
	
	
	
}