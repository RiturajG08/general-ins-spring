package com.lti.repository;

public class DepreciationRepository extends GenericRepository {

	public int getVhehiclePrice(int id) {
		return (Integer)
				entityManager
				.createQuery("select v.price from Vehicle v where v.id= : id ")
				.setParameter("id", id)
				.getSingleResult();
	}
}