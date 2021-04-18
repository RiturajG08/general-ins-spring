package com.lti.service;

import com.lti.repository.DepreciationRepository;

public class DepreciationService {

	public int getPriceOfVehilce(int id) {
		DepreciationRepository repo= new DepreciationRepository();
		return repo.getVhehiclePrice(id);
	}
}
