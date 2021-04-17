package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.lti.dto.VehicleStatus;
import com.lti.entity1.Vehicle;
import com.lti.exception.VehicleServiceException;
import com.lti.service.VehicleService;

@RestController
@CrossOrigin
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/vehicle")
	public VehicleStatus register(@RequestBody Vehicle vehicle ) {
		try {
			int id= vehicleService.register(vehicle);
			VehicleStatus status= new VehicleStatus();
			status.setStatus(true);
			status.setMessage("Registration Successfull");
			status.setRegisterVihicleId(id);;
			return status;
		}
		catch(VehicleServiceException e) {
			VehicleStatus status= new VehicleStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
}
