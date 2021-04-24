package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.VehicleStatus;
import com.lti.entity1.Depreciation;
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
			
			Vehicle newVehicle= vehicleService.addVehicle(vehicle);
		    Depreciation newDepreciation=vehicleService.add(newVehicle.getId());
			
			VehicleStatus status= new VehicleStatus();
			status.setStatus(true);
			status.setMessage("Registration Successfull");
			status.setRegisterVehicleId(newVehicle.getId());
			status.setVehicleNumber(newVehicle.getNumber());
			status.setDid(newDepreciation.getId());
			status.setDepreciationAmount(newDepreciation.getDepreciationAmount());
			status.setIdv(newDepreciation.getIdv());
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
