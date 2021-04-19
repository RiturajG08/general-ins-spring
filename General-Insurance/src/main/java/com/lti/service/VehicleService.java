package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity1.Customer;
import com.lti.entity1.Vehicle;
import com.lti.exception.VehicleServiceException;
import com.lti.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	public int register(Vehicle vehicle) {
		if(vehicleRepository.isVechiclePresent(vehicle.getNumber())) {
			throw new VehicleServiceException("vehicle already registered !");
		}
			Customer customer= (Customer) vehicleRepository.findById(1006);
			Vehicle updatedVehicle= (Vehicle) vehicleRepository.save(vehicle);
			updatedVehicle.setCustomer(customer);
			vehicleRepository.save(updatedVehicle);
			
			
			return updatedVehicle.getId();
		}
	}
	

