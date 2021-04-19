package com.lti;

import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.entity1.Customer;
import com.lti.entity1.Vehicle;
import com.lti.repository.CustomerRepository;
import com.lti.repository.DepreciationRepository;
import com.lti.repository.GenericRepository;
import com.lti.service.DepreciationService;

@SpringBootTest
class GeneralInsuranceApplicationTests {
	
	@Autowired
	private DepreciationService ds;

	/*@Test
	public void addGetVehiclePrice() {
		System.out.println("Price Of Vehicle is "+ds.getPriceOfVehilce(2001));	
	}*/
	
	@Test
	public void addGetVehicleAge() {
		LocalDate firstDate =LocalDate.now();
		LocalDate secondDate = ds.getAgeOfVehicle(2002);
		//long time_difference = date2.getTime() - date1.getTime();  
		System.out.println(Period.between(firstDate, secondDate));
	}
	
	/*
	 * Date date1 = obj.parse(join_date);   
            Date date2 = obj.parse(leave_date);   
            // Calucalte time difference in milliseconds   
            long time_difference = date2.getTime() - date1.getTime();  
            // Calucalte time difference in days  
            long days_difference = (time_difference / (1000*60*60*24)) % 365;   
            // Calucalte time difference in years  
            long years_difference = (time_difference / (1000l*60*60*24*365));
	 */
	
	
	@Test
	public void getCustomer() {
		CustomerRepository repo= new CustomerRepository();
		int sc = repo.fetchByEmailAndPassword("anand@gmail.com", "123");
		System.out.println(sc);
	}

}
