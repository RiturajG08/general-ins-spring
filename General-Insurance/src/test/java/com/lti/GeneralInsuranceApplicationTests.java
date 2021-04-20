package com.lti;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	
	@Test
	public void getCustomer() {
		CustomerRepository repo= new CustomerRepository();
		int sc = repo.fetchByEmailAndPassword("anand@gmail.com", "123");
		System.out.println(sc);
	}
	
	
	

	
	
}
