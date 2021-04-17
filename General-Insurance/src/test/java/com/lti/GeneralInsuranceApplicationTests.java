package com.lti;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.entity1.Customer;
import com.lti.repository.GenericRepository;

@SpringBootTest
class GeneralInsuranceApplicationTests {

	@Test
	public void addCust() {
		Customer cust= new Customer();
		cust.setName("Harshit");
		cust.setEmail("harshit@gmail.com");
		cust.setPassword("Harshit123");
		cust.setDateOfBirth(LocalDate.of(1998, 12, 12));
		cust.setAddress("Talao-Pali");
		cust.setCity("Thane");
		cust.setState("Maharashtra");
		cust.setPincode(421301);
		cust.setMobileNumber(1234678);
		
		GenericRepository repo= new GenericRepository();
		repo.save(cust);
	}

}
