package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity1.Vehicle;
import com.lti.exception.VehicleServiceException;
import com.lti.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService implements VehicleInterface {

	@Autowired
	private VehicleRepository vehicleRepository;

	public int addVehicle(Vehicle vehicle) {
		if(vehicleRepository.isVechiclePresent(vehicle.getNumber())) {
			throw new VehicleServiceException("vehicle already registered !");
		}
		Vehicle updatedVehicle= (Vehicle) vehicleRepository.save(vehicle);
		return updatedVehicle.getId();
		}
	}