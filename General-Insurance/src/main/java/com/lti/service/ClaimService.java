package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.ClaimDto;
import com.lti.entity1.Claim;
import com.lti.entity1.Policy;
import com.lti.entity1.Vehicle;
import com.lti.exception.VehicleServiceException;
import com.lti.repository.ClaimRepository;

@Service
@Transactional
public class ClaimService {
	
	@Autowired
	private ClaimRepository claimRepository;
	
	public int addClaim(int pid, String reason) {
		
		Policy policy = (Policy) claimRepository.find(Policy.class, pid);
		Claim claim = new Claim();
		claim.setClaimDate(LocalDate.now());
		claim.setReason(reason);
		claim.setPolicy(policy);
		claim.setStatus("Waiting");
		Claim updatedClaim = (Claim) claimRepository.save(claim);
		return updatedClaim.getId();
		}
	
	public List<Claim> searchClaims(){
		return claimRepository.searchAllClaims();
		
	}
	
	
}
