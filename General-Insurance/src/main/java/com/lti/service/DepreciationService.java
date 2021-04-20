package com.lti.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.DepreciationStatus;
import com.lti.entity1.Depreciation;
import com.lti.entity1.Vehicle;
import com.lti.exception.VehicleServiceException;
import com.lti.repository.DepreciationRepository;
import java.text.SimpleDateFormat;  
import java.text.ParseException;   
import java.util.Date;
import java.time.temporal.ChronoUnit;

@Service
@Transactional
public class DepreciationService {
	
	@Autowired
	private DepreciationRepository depriciationRepo;
	
	public Depreciation addDepreciationToVehicle(int id) {
		int price= depriciationRepo.fetchVehiclePrice(id);
		
		LocalDate registrationDate= depriciationRepo.fetchVehicleAge(id);
		LocalDate todayDate= LocalDate.now();
		
		long noOfMonthsBetween=0;
		double depreciationPrice=0;
		int depreciationPercentage=0;
		
        noOfMonthsBetween = ChronoUnit.MONTHS.between(registrationDate, todayDate);
		
		if(noOfMonthsBetween <= 12) {
			depreciationPrice= price*0.1;
			depreciationPercentage= 10;
		}
		else if(noOfMonthsBetween >12 && noOfMonthsBetween <=24) {
			depreciationPrice= price*0.2;
			depreciationPercentage= 20;
		}
		else if(noOfMonthsBetween >24 && noOfMonthsBetween <=36) {
			depreciationPrice= price*0.3;
			depreciationPercentage= 30;
		}
		else if(noOfMonthsBetween >36 && noOfMonthsBetween <=48) {
			depreciationPrice= price*0.4;
			depreciationPercentage= 40;
		}
		else {
			depreciationPrice= price*0.5;
			depreciationPercentage= 50;
		}
		
		long age=(int) Math.ceil(noOfMonthsBetween/12);
		
		Vehicle vehicle= (Vehicle) depriciationRepo.find(Vehicle.class, id);
		
		Depreciation depreciation= new Depreciation();
		depreciation.setDepreciationAmount(depreciationPrice);
		depreciation.setVehicleAge(age);
		depreciation.setPercentage(depreciationPercentage);
		depreciation.setVehicle(vehicle);
		
		depriciationRepo.save(depreciation);
		return depreciation;
	}
	
}
