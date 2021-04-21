package com.lti.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity1.Customer;
import com.lti.entity1.Policy;
import com.lti.exception.CustomerServiceException;
import com.lti.repository.RenewalRepository;

@Service
@Transactional
public class RenewalService {
	
	@Autowired
	private RenewalRepository renewalRepository;
	
	/*public Policy renew(int id) {
		try {
			int pid= renewalRepository.fetchByPolicyId(id);
	//		Policy policy= renewalRepository.find(Policy.class, pid);
			
			LocalDate endDateOfPolicy= renewalRepository.fetchEndDateOfPolicy(id);
			LocalDate startDateOfPolicy= renewalRepository.fetchStartDateOfPolicy(id);
			LocalDate registerationVehicledate= renewalRepository.fetchVehicleRegistartionDate(id);
			LocalDate todayDate= LocalDate.now();
			if(todayDate.compareTo(endDateOfPolicy) < 0) {
				
				long policyPeriod = ChronoUnit.YEARS.between(endDateOfPolicy, startDateOfPolicy );
				LocalDate newStartDate =renewalRepository.fetchEndDateOfPolicy(id);
				LocalDate newEndDate=renewalRepository.fetchEndDateOfPolicy(id).plusYears(policyPeriod);
				
				//double idv=renewalRepository.fetchIdvOfPolicy(id);	
				double newIdv;
				long ageOfVehicle = ChronoUnit.MONTHS.between(registerationVehicledate, LocalDate.now());
				int vehiclePrice = renewalRepository.fetchVehiclePrice(id);
				
				double premium =0;
				
				
				double depreciation=0;
					if(ageOfVehicle <12) {
						depreciation= vehiclePrice*0.1;
						newIdv=vehiclePrice-depreciation;
						premium = newIdv*0.05;	
					}
					else if(ageOfVehicle >12 && ageOfVehicle <=24) {
						depreciation= vehiclePrice*0.2;
						newIdv=vehiclePrice-depreciation;
						premium = newIdv*0.05;	
					}
					else if(ageOfVehicle >24 && ageOfVehicle <=36) {
						depreciation= vehiclePrice*0.3;
						newIdv=vehiclePrice-depreciation;
						premium = newIdv*0.05;	
					}
					else if(ageOfVehicle >36 && ageOfVehicle <=48) {
						depreciation= vehiclePrice*0.4;
						newIdv=vehiclePrice-depreciation;
						premium = newIdv*0.05;	
					}
					else {
						depreciation= vehiclePrice*0.5;
						newIdv=vehiclePrice-depreciation;
						premium = newIdv*0.05;
					}
					
					Policy policy= (Policy) renewalRepository.find(Policy.class, id);
					
					policy.setPremium(premium);
					policy.setPolicyStartDate(newStartDate);
					policy.setPolicyEndDate(newEndDate);
					policy.setIdv(newIdv);
					renewalRepository.save(policy);
					return policy;			
			} 
			else {
				System.out.println("your policy has expired You have to buy new policy");
				return null;
			}
			
		
				
		}
		catch(EmptyResultDataAccessException e) {
			throw new CustomerServiceException("please enter valid policy  number");
		}
		
		
		
	}  */
	
	public Policy login(int id) {
		try {
		//	password= Base64.getEncoder().encodeToString(password.getBytes());
			int pid= renewalRepository.fetchByPolicyId(id);
			Policy policy= renewalRepository.find(Policy.class, pid);
			return policy;
		}
		catch(EmptyResultDataAccessException e) {
			throw new CustomerServiceException("Invalid policy number");
		}
	}

}
