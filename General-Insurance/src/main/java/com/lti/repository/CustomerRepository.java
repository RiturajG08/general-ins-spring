package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity1.Claim;
import com.lti.entity1.Policy;

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
				.createQuery("select c.id from Customer c where c.email= : em and c.password= :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}
	
	public String fetchEmail(String email) {
		return (String)
				entityManager
				.createQuery("select c.email from Customer c where c.email= :cemail")
				.setParameter("cemail", email)
				.getSingleResult();
	}
	
	public List<Policy> searchPolicyByCustomer(int id) {
		return entityManager.createQuery("select p.id, p.premium, p.policyStartDate, p.policyEndDate, p.type, p.eachYearIdv, p.totalIdv,p.period, p.vehicle.number from Policy p where p.customer.id=:cid")
				.setParameter("cid", id)
				.getResultList();			
	}
	
}

