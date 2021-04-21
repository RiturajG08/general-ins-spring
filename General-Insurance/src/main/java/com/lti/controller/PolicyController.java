package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.PolicyDto;
import com.lti.dto.PolicyStatus;
import com.lti.dto.VehicleStatus;
import com.lti.entity1.Policy;
import com.lti.entity1.Vehicle;
import com.lti.exception.VehicleServiceException;
import com.lti.service.PolicyService;

@RestController
@CrossOrigin
public class PolicyController {
	
	@Autowired
	private PolicyService  policyService;
	
	@PostMapping("/policy")
	public PolicyStatus addPolicy(@RequestBody PolicyDto policyDto ) {
		//try {
			
			int id= policyService.addPolicyToVehicle(policyDto.getId());
			
			PolicyStatus status= new PolicyStatus();
			status.setStatus(true);
			status.setMessage("Policy buyed successfully!");
			status.setPolicyId(id);
			return status;
		//}
		/*catch(VehicleServiceException e) {
			PolicyStatus status= new PolicyStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}*/
	}
	
	

	
	
}
