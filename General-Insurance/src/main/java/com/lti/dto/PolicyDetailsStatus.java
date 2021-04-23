package com.lti.dto;

import java.time.LocalDate;

public class PolicyDetailsStatus {
	
	private int policyNumber;
	private LocalDate startDate;
	private LocalDate endDate;
	private double idv;
	private double premium;
	private double totalIdv;
	
	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
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
	public double getIdv() {
		return idv;
	}
	public void setIdv(double idv) {
		this.idv = idv;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public double getTotalIdv() {
		return totalIdv;
	}
	public void setTotalIdv(double totalIdv) {
		this.totalIdv = totalIdv;
	}
}
