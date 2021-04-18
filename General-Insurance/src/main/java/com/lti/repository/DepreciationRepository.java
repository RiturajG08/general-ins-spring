package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DepreciationRepository extends GenericRepository {

	public int getVhehiclePrice(int id) {
		return (Integer)
				entityManager
				.createQuery("select v.price from Vehicle v where v.id = :vid ")
				.setParameter("vid", id)
				.getSingleResult();
	}
}