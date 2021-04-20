package com.lti.repository;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

@Repository
public class RenewalRepository extends GenericRepository{

	public boolean isPolicyPresent(int id) {
		return (Long)
				entityManager
				.createQuery("select count(p.id) from policy p where p.id= :em")
				.setParameter("em", id)
				.getSingleResult()== 1 ? true : false;
	}
	
	public LocalDate fetchEndDateOfPolicy(int id) {
		return (LocalDate)
				entityManager
				.createQuery("select p.policyEndDate from Policy p where p.id= :pid")
				.setParameter("pid", id)
				.getSingleResult();
}
}