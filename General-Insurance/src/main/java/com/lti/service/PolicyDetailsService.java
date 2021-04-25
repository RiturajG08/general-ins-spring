package com.lti.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.PolicyDetailsDto;
import com.lti.entity1.Policy;
import com.lti.entity1.Vehicle;
import com.lti.repository.PolicyDetailsRepository;


@Service
@Transactional
public class PolicyDetailsService implements PolicyDetailsInterface {
	
	@Autowired
	private PolicyDetailsRepository policyDetailsRepository;
	
	public PolicyDetailsDto addPolicyToVehicle(int cid, int did, int vid, String period , String type) {	
		if(type.equals("Comprehensive")) {
			double eachYearIdv=  policyDetailsRepository.calculateIdv(cid, did, vid, period, type);
			double premium=0;
			double totalIdv=0;
			
			LocalDate startDate= LocalDate.now();
			PolicyDetailsDto policyDetailsDto = new PolicyDetailsDto();
			policyDetailsDto.setEachYearIdv(eachYearIdv);
			policyDetailsDto.setPolicyType(type);
			policyDetailsDto.setStartDate(startDate);
			
			LocalDate endDate;
			
			if(period.equals("One Year")) {
				endDate= startDate.plusYears(1);
				totalIdv= eachYearIdv*1;
			}
			else if (period.equals("Three Year")) {
				endDate= startDate.plusYears(3);
				totalIdv= eachYearIdv*3;
			}
			else if (period.equals("Five Year")) {
				endDate= startDate.plusYears(5);
				totalIdv= eachYearIdv*5;
			}
			else {
				endDate= null;
			}
			
			policyDetailsDto.setTotalIdv(totalIdv);
			
			premium= totalIdv*0.05;
			policyDetailsDto.setPremium(premium);
			policyDetailsDto.setEndDate(endDate);
			
			PolicyDetailsDto updatedPolicyDetailsDto= (PolicyDetailsDto) policyDetailsRepository.save(policyDetailsDto) ;
			return updatedPolicyDetailsDto;
		}
		else if(type.equals("Third Party")) {
			
			double eachYearIdv=  policyDetailsRepository.calculateIdv(cid, did, vid, period, type);
			double premium=0;
			double totalIdv=0;
			LocalDate startDate= LocalDate.now();
			
			eachYearIdv= eachYearIdv- eachYearIdv*0.1;
			
			PolicyDetailsDto policyDetailsDto = new PolicyDetailsDto();
			policyDetailsDto.setEachYearIdv(eachYearIdv);
			policyDetailsDto.setPolicyType(type);
			policyDetailsDto.setStartDate(startDate);
			
			LocalDate endDate;
			
			if(period.equals("One Year")) {
				endDate= startDate.plusYears(1);
				totalIdv= eachYearIdv*1;
			}
			else if (period.equals("Three Year")) {
				endDate= startDate.plusYears(3);
				totalIdv= eachYearIdv*3;
			}
			else if (period.equals("Five Year")) {
				endDate= startDate.plusYears(5);
				totalIdv= eachYearIdv*5;
			}
			else {
				endDate= null;
			}
			
			policyDetailsDto.setTotalIdv(totalIdv);
			
			premium= totalIdv*0.05;
			policyDetailsDto.setPremium(premium);
			policyDetailsDto.setEndDate(endDate);
			
			PolicyDetailsDto updatedPolicyDetailsDto= (PolicyDetailsDto) policyDetailsRepository.save(policyDetailsDto) ;
			return updatedPolicyDetailsDto;
		}
		return null;
	}
}
