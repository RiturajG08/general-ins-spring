package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends GenericRepository {

	public boolean isCustomerPresent(String email) {
		return (Long)
				entityManager
				.createQuery("select count(c.id) from Customer c where c.email= :em")
				.setParameter("em", email)
				.getSingleResult()== 1 ? true : false;
	}
	
	public int fetchByEmailAndPassword(String email, String password) {
		return (Integer)
				entityManager
				.createQuery("select c.id from customer c where c.email= : em and c.password= :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}
}
