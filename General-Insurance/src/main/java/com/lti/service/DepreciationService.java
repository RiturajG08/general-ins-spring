package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.repository.DepreciationRepository;

@Service
@Transactional
public class DepreciationService {
	
	@Autowired
	private DepreciationRepository depriciationRepo;

	/*public int getPriceOfVehilce(int id) {
		return depriciationRepo.fetchVehicleAge(id);
	}
	
	public int getAgeOfVehicle(int id) {
		return depriciationRepo.fetchVehicleAge(id);
	}*/
	
	
}
