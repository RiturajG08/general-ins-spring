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
import com.lti.exception.RenewalServiceException;
import com.lti.repository.PolicyRepository;
import com.lti.repository.RenewalRepository;

@Service
@Transactional
public class RenewalService implements RenewalInterface{
	
	@Autowired
	private RenewalRepository renewalRepository;
	
	private PolicyRepository policyRepository;
	
	public Policy renewOldPolicy(int pid, String number, String type, String period) {
		
		try {
			Policy policy =(Policy) renewalRepository.find(Policy.class, pid);
			
			LocalDate registerationVehicleDate= renewalRepository.fetchVehicleRegistartionDate(pid,number,type, period);
			long ageOfVehicle = ChronoUnit.MONTHS.between(registerationVehicleDate, LocalDate.now());
			int priceOfTheVehicle = renewalRepository.fetchVehiclePrice(pid, number, type, period);
			
			LocalDate  startDateOfRenewPolicy=renewalRepository.fetchEndDateOfPolicy(pid);
			
			double idv=0;
			double totalIdv=0;
			double preminum=0;
			double drep=0;
			LocalDate endDateOfRenewPolicy =null;
			if(type.equals("Comprehensive")) {
				if(period.equals("One Year")) {
					  if(ageOfVehicle>12 && ageOfVehicle<=24) {
						  drep = priceOfTheVehicle *0.2;
						  idv=priceOfTheVehicle-drep;
						  totalIdv=idv*1;
						  preminum=idv*0.05;
						  endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(1);
					 }
					 else if(ageOfVehicle>24 && ageOfVehicle<=36) {
						 drep = priceOfTheVehicle *0.3;
						 idv=priceOfTheVehicle-drep;
						 totalIdv=idv*1;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(1);
					 }
					 else if(ageOfVehicle>36 && ageOfVehicle<=48) {
						 drep = priceOfTheVehicle *0.4;
						 idv=priceOfTheVehicle-drep;
						 totalIdv=idv*1;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(1);
					 }
					 else {
						 drep = priceOfTheVehicle *0.5;
						 idv=priceOfTheVehicle-drep;
						 totalIdv=idv*1;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(1);
					 }
				}
				
				if(period.equals("Three Year")) {
					 if(ageOfVehicle>12 && ageOfVehicle<=24) {
						 drep = priceOfTheVehicle *0.2;
						 idv=priceOfTheVehicle-drep;
						 totalIdv=idv*3;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(3);
					 }
					 else if(ageOfVehicle>24 && ageOfVehicle<=36) {
						 drep = priceOfTheVehicle *0.3;
						 idv=priceOfTheVehicle-drep;
						 totalIdv=idv*3;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(3);
					 }
					 else if(ageOfVehicle>36 && ageOfVehicle<=48) {
						 drep = priceOfTheVehicle *0.4;
						 idv=priceOfTheVehicle-drep;
						 totalIdv=idv*3;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(3);
					 }
					 else {
						 drep = priceOfTheVehicle *0.5;
						 idv=priceOfTheVehicle-drep;
						 preminum=idv*0.05;
						 totalIdv=idv*3;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(3);
					 }
				}
				
				if(period.equals("Five Year")) {
					 if(ageOfVehicle>12 && ageOfVehicle<=24) {
						 drep = priceOfTheVehicle *0.2;
						 idv=priceOfTheVehicle-drep;
						 totalIdv=idv*5;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(5);
					 }
					 else if(ageOfVehicle>24 && ageOfVehicle<=36) {
						 drep = priceOfTheVehicle *0.3;
						 idv=priceOfTheVehicle-drep;
						 totalIdv=idv*5;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(5);
					 }
					 else if(ageOfVehicle>36 && ageOfVehicle<=48) {
						 drep = priceOfTheVehicle *0.4;
						 idv=priceOfTheVehicle-drep;
						 totalIdv=idv*5;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(5);
					 }
					 else {
						 drep = priceOfTheVehicle *0.5;
						 idv=priceOfTheVehicle-drep;
						 totalIdv=idv*5;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(5);
					 }
				}	
				
				policy.setEachYearIdv(idv);
				policy.setTotalIdv(totalIdv);
				policy.setPolicyStartDate(startDateOfRenewPolicy);
				policy.setPolicyEndDate(endDateOfRenewPolicy);
				policy.setPremium(preminum);
				
				Policy updatedPolicy=(Policy) renewalRepository.save(policy);
				return updatedPolicy;	
			}
			
			else if(type.equals("Third Party")) {
				if(period.equals("One Year")) {
					  if(ageOfVehicle>12 && ageOfVehicle<=24) {
						  drep = priceOfTheVehicle *0.2;
						  idv=priceOfTheVehicle-drep;
						  idv=idv-idv*0.1;
						  totalIdv=idv*1;
						  preminum=idv*0.05;
						  endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(1);
					 }
					 else if(ageOfVehicle>24 && ageOfVehicle<=36) {
						 drep = priceOfTheVehicle *0.3;
						 idv=priceOfTheVehicle-drep;
						 idv=idv-idv*0.1;
						 totalIdv=idv*1;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(1);
					 }
					 else if(ageOfVehicle>36 && ageOfVehicle<=48) {
						 drep = priceOfTheVehicle *0.4;
						 idv=priceOfTheVehicle-drep;
						 idv=idv-idv*0.1;
						 totalIdv=idv*1;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(1);
					 }
					 else {
						 drep = priceOfTheVehicle *0.5;
						 idv=priceOfTheVehicle-drep;
						 idv=idv-idv*0.1;
						 totalIdv=idv*1;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(1);
					 }
				}
				
				if(period.equals("Three Year")) {
					 if(ageOfVehicle>12 && ageOfVehicle<=24) {
						 drep = priceOfTheVehicle *0.2;
						 idv=priceOfTheVehicle-drep;
						 idv=idv-idv*0.1;
						 totalIdv=idv*3;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(3);
					 }
					 else if(ageOfVehicle>24 && ageOfVehicle<=36) {
						 drep = priceOfTheVehicle *0.3;
						 idv=priceOfTheVehicle-drep;
						 idv=idv-idv*0.1;
						 totalIdv=idv*3;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(3);
					 }
					 else if(ageOfVehicle>36 && ageOfVehicle<=48) {
						 drep = priceOfTheVehicle *0.4;
						 idv=priceOfTheVehicle-drep;
						 idv=idv-idv*0.1;
						 totalIdv=idv*3;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(3);
					 }
					 else {
						 drep = priceOfTheVehicle *0.5;
						 idv=priceOfTheVehicle-drep;
						 idv=idv-idv*0.1;
						 preminum=idv*0.05;
						 totalIdv=idv*3;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(3);
					 }
				}
				
				if(period.equals("Five Year")) {
					 if(ageOfVehicle>12 && ageOfVehicle<=24) {
						 drep = priceOfTheVehicle *0.2;
						 idv=priceOfTheVehicle-drep;
						 idv=idv-idv*0.1;
						 totalIdv=idv*5;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(5);
					 }
					 else if(ageOfVehicle>24 && ageOfVehicle<=36) {
						 drep = priceOfTheVehicle *0.3;
						 idv=priceOfTheVehicle-drep;
						 idv=idv-idv*0.1;
						 totalIdv=idv*5;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(5);
					 }
					 else if(ageOfVehicle>36 && ageOfVehicle<=48) {
						 drep = priceOfTheVehicle *0.4;
						 idv=priceOfTheVehicle-drep;
						 idv=idv-idv*0.1;
						 totalIdv=idv*5;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(5);
					 }
					 else {
						 drep = priceOfTheVehicle *0.5;
						 idv=priceOfTheVehicle-drep;
						 idv=idv-idv*0.1;
						 totalIdv=idv*5;
						 preminum=idv*0.05;
						 endDateOfRenewPolicy=startDateOfRenewPolicy.plusYears(5);
					 }
				}	
				
				policy.setEachYearIdv(idv);
				policy.setTotalIdv(totalIdv);
				policy.setPolicyStartDate(startDateOfRenewPolicy);
				policy.setPolicyEndDate(endDateOfRenewPolicy);
				policy.setPremium(preminum);
				
				Policy updatedPolicy=(Policy) renewalRepository.save(policy);
				return updatedPolicy;
				
			}
			else{
				return policy;
			}		
		}
		catch(EmptyResultDataAccessException e) {
			throw new RenewalServiceException("Invalid Vehicle number");
		}
	    
			
	} 
			

	public Policy checkPolicyNumber(int id) {
		try {
			int pid= renewalRepository.fetchByPolicyId(id);
			Policy policy= (Policy)renewalRepository.find(Policy.class, pid);
			return policy;
		}
		catch(EmptyResultDataAccessException e) {
			throw new RenewalServiceException("Invalid policy number");
		}
	}

}
