package com.lti;

import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.entity1.Customer;
import com.lti.entity1.Depreciation;
import com.lti.entity1.Policy;
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
	
	/*@Test
	public void addGetVehicleAge() {
		LocalDate firstDate =LocalDate.now();
		LocalDate secondDate = ds.getAgeOfVehicle(2002);
		//long time_difference = date2.getTime() - date1.getTime();  
		System.out.println(Period.between(firstDate, secondDate));
	}*/
	
	/*@Test
	public void check() {
		System.out.println(ds.getDepreciationAmount(500000, LocalDate.of(2020, 02, 15)));
		//System.out.println("months between"+ds.addDepreciation(depreciation)
	}*/
	
	
	
	
	@Test
	public void addPolicyToVehicle() {
	GenericRepository dao= new GenericRepository();
	Customer cust= (Customer)dao.find(Customer.class, 1010);
	Vehicle vehicle= (Vehicle)dao.find(Vehicle.class, 2031);
	Depreciation depreciation= (Depreciation)dao.find(Depreciation.class, 5011);

	Policy policy= new Policy();
	policy.setType("Third-Party");;
	policy.setRenewal('n');
	policy.setPolicyStartDate(LocalDate.of(2020, 7, 4));
	policy.setPolicyEndDate(LocalDate.of(2021, 7, 4));
	policy.setPremium(30000);;
	policy.setIdv(900000);
	policy.setCustomer(cust);
	policy.setVehicle(vehicle);
	policy.setDepreciation(depreciation);

	dao.save(policy);
	}

	
	
}
