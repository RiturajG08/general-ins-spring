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

	/*public int getPriceOfVehilce(int id) {
		return depriciationRepo.fetchVehicleAge(id);
	}*/
	
	/*public LocalDate getAgeOfVehicle(int id) {
		return depriciationRepo.fetchVehicleAge(id);
		
	}
	
	long noOfMonthsBetween=0;
	
	public double getDepreciationAmount(int price, LocalDate registrationDate) {
		
		
		DepreciationStatus ds = new DepreciationStatus();
		LocalDate firstDate =LocalDate.now();
		LocalDate secondDate = ds.getRegistrationDate();
		//long noOfDaysBetween = ChronoUnit.DAYS.between(firstDate, secondDate);
		 noOfMonthsBetween = ChronoUnit.MONTHS.between(firstDate, secondDate);
		if(noOfMonthsBetween <= 12) {
			return (price * 0.1);
		}
		else if(noOfMonthsBetween >12 && noOfMonthsBetween <=24) {
			return (price * 0.2);
		}
		else if(noOfMonthsBetween >24 && noOfMonthsBetween <=36) {
			return (price * 0.3);
		}
		else {
			return  (price * 0.4);
		}
	}
	
	public int addDepreciation(Depreciation depreciation) {
		
		Depreciation addDep= (Depreciation) depriciationRepo.save(depreciation);
	addDep.setVehicleAge(noOfMonthsBetween);
	//	addDep.setDepreciationAmount(getDepreciationAmount(10000, LocalDate.of(2018, 9, 4)));
		depriciationRepo.save(addDep);
		return addDep.getId();
		}*/
	
	public Depreciation addDepreciationToVehicle(int id) {
		int price= depriciationRepo.fetchVehiclePrice(id);
		
		LocalDate newDate= depriciationRepo.fetchVehicleAge(id);
		LocalDate firstDate= LocalDate.now();
		
		long noOfMonthsBetween=0;
		double depreciationPrice=0;
		
		noOfMonthsBetween = ChronoUnit.MONTHS.between(firstDate, newDate);
		
		if(noOfMonthsBetween <= 12) {
			depreciationPrice= price*0.1;
		}
		else if(noOfMonthsBetween >12 && noOfMonthsBetween <=24) {
			depreciationPrice= price*0.2;
		}
		else if(noOfMonthsBetween >24 && noOfMonthsBetween <=36) {
			depreciationPrice= price*0.3;
		}
		else if(noOfMonthsBetween >36 && noOfMonthsBetween <=48) {
			depreciationPrice= price*0.4;
		}
		else {
			depreciationPrice= price*0.5;
		}
		
		Depreciation depreciation= new Depreciation();
		depreciation.setDepreciationAmount(depreciationPrice);
		depreciation.setVehicleAge(noOfMonthsBetween/12);
		
		depriciationRepo.save(depreciation);
		return depreciation;
	}
	
}
	
	
	
	

