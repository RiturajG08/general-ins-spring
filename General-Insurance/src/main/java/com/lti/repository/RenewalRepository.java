package com.lti.repository;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

@Repository
public class RenewalRepository extends GenericRepository{

	public int fetchByPolicyId(int id) {
		return (Integer)
				entityManager
				.createQuery("select p.id from Policy p where p.id= : pid")
				.setParameter("pid", id)
				.getSingleResult();
	}
	
	public LocalDate fetchEndDateOfPolicy(int id) {
		return (LocalDate)
				entityManager
				.createQuery("select p.policyEndDate from Policy p where p.id= :pid")
				.setParameter("pid", id)
				.getSingleResult();
    }
	
	public LocalDate fetchStartDateOfPolicy(int id) {
		return (LocalDate)
				entityManager
				.createQuery("select p.policyStartDate from Policy p where p.id= :pid")
				.setParameter("pid", id)
				.getSingleResult();
    }
	
	public double fetchIdvOfPolicy(int id) {
		return (double)
				entityManager
				.createQuery("select p.idv from Policy p where p.id= : pid")
				.setParameter("pid", id)
				.getSingleResult();
	}
	
	public LocalDate fetchVehicleRegistartionDate(int id) {
		return (LocalDate)
				entityManager
				.createQuery(" select  v.registrationDate from Vehicle v INNER JOIN   where p.id=pid")
				// Select v.registration_date from vehicle_tbl v join policy_tbl p on v.id = p.vehicle_id where p.id=3002;
				// select  v.registrationDate from Vehicle v INNER JOIN  fetch p.vid p where p.id=:pid"
				// select e from Employee e  INNER JOIN e.passport p where p.expiredate <:date
				//SELECT c1, c2 FROM Country c1 INNER JOIN c1.neighbors c2
				.setParameter("pid", id)
				.getSingleResult();
    }
	
	public int fetchVehiclePrice(int id) {
		return (int)
				entityManager
				.createQuery(" select  v.price from Vehicle v INNER JOIN  fetch v.policy p where p.id=:pid")
				.setParameter("pid", id)
				.getSingleResult();
	}
	
	
	
	
	
}