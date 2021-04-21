package com.lti.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.PolicyDto;
import com.lti.entity1.Customer;
import com.lti.entity1.Depreciation;
import com.lti.entity1.Policy;
import com.lti.entity1.Vehicle;
import com.lti.repository.PolicyRepository;

@Service
@Transactional
public class PolicyService {
	
	@Autowired
	private PolicyRepository policyRepository;
	

	public int addPolicyToVehicle(int cid, int did, int vid, String period , LocalDate startDate, String type) {
		double idv=  policyRepository.calculateIdv(cid, did, vid, period, startDate, type);
		double premium= idv*0.05;
		
		//LocalDate newEndDate=renewalRepository.fetchEndDateOfPolicy(id).plusYears(policyPeriod);
		
		
		Policy policy = new Policy();
		policy.setIdv(idv);
		policy.setPremium(premium);
		policy.setType(type);
		policy.setPolicyStartDate(startDate);
		
		LocalDate endDate;
		
		if(period.equals("One Year")) {
			endDate= startDate.plusYears(1);
		}
		else if (period.equals("Three Year")) {
			endDate= startDate.plusYears(3);
		}
		else if (period.equals("Five Year")) {
			endDate= startDate.plusYears(5);
		}
		else {
			endDate= null;
		}
		
		policy.setPolicyEndDate(endDate);
		
		Depreciation depreciation= (Depreciation) policyRepository.find(Depreciation.class, did);
		Customer customer= (Customer) policyRepository.find(Customer.class, cid);
		Vehicle vehicle= (Vehicle) policyRepository.find(Vehicle.class, vid);
		
		policy.setCustomer(customer);
		policy.setVehicle(vehicle);
		policy.setDepreciation(depreciation);
		
		Policy updatedPolicy= (Policy) policyRepository.save(policy);
		return updatedPolicy.getId();
	}
}
