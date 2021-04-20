package com.lti.service;

import java.time.LocalDate;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lti.entity1.Policy;
import com.lti.exception.CustomerServiceException;
import com.lti.repository.RenewalRepository;

@Service
@Transactional
public class RenewalService {
	
	@Autowired
	private RenewalRepository renewalRepository;
	
	/*public Policy login(int id) {
		LocalDate endDateOfPolicy= renewalRepository.fetchEndDateOfPolicy(id);
		LocalDate todayDate= LocalDate.now();
		
		return policy;
	} */

}
