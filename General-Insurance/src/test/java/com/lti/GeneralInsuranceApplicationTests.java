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
	
	@Test
	public void check() {
		System.out.println(ds.getDepreciationAmount(500000, LocalDate.of(2020, 02, 15)));
		//System.out.println("months between"+ds.addDepreciation(depreciation)
	}
	
	
	
	
	@Test
	public void getCustomer() {
		CustomerRepository repo= new CustomerRepository();
		int sc = repo.fetchByEmailAndPassword("anand@gmail.com", "123");
		System.out.println(sc);
	}

	
	
}
