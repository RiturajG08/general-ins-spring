package com.lti.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PolicyDetailsDto {
	
	@Id
	private int id;
	
	private String policyType;
	private LocalDate startDate;
	private LocalDate endDate;
	private double eachYearIdv;
	private double totalIdv;
	private double premium;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public double getEachYearIdv() {
		return eachYearIdv;
	}
	public void setEachYearIdv(double eachYearIdv) {
		this.eachYearIdv = eachYearIdv;
	}
	public double getTotalIdv() {
		return totalIdv;
	}
	public void setTotalIdv(double totalIdv) {
		this.totalIdv = totalIdv;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	

}
