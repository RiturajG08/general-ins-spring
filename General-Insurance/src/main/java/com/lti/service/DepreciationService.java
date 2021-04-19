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
	
	public LocalDate getAgeOfVehicle(int id) {
		return depriciationRepo.fetchVehicleAge(id);
		
	}
	
	
	
	public double getDepreciationAmount(int price, LocalDate registrationDate) {
		long noOfMonthsBetween=0;
		
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
		//addDep.setVehicleAge(noOfMonthsBetween);
	//	addDep.setDepreciationAmount(getDepreciationAmount(10000, LocalDate.of(2018, 9, 4)));
		depriciationRepo.save(addDep);
		return addDep.getId();
		}
	
	}
	
	
	
	

