package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.DepreciationDto;
import com.lti.dto.DepreciationStatus;
import com.lti.service.DepreciationService;

@RestController
@CrossOrigin
public class DepreciationController {
	
	@Autowired
	private DepreciationService depreciationService;
	
	@PostMapping("/depreciation")
	public DepreciationStatus addDepreciation(@RequestBody DepreciationDto depreciationDto ) {
			int depId= depreciationService.addDepreciationToVehicle(depreciationDto.getId());
			DepreciationStatus status= new DepreciationStatus();
			status.setStatus(true);
			status.setMessage("depreciation added sucessfully!");
			status.setDepreciationId(depId);
			return status;
}
}
