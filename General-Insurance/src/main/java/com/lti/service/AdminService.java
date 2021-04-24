package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.AdminDto;
import com.lti.entity1.Claim;
import com.lti.repository.AdminRepository;

@Service
@Transactional
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Claim searchByClaimId(int id, int amount, String status) {
	
		Claim claim = (Claim) adminRepository.fetchClaimById(id);
		claim.setAmount(amount);
		claim.setStatus("Approved");
		
		Claim updatedClaim = (Claim) adminRepository.save(claim);
		return updatedClaim;
	}
}
