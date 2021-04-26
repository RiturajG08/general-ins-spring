package com.lti.dto;

import java.time.LocalDate;

public class RenewalStatus extends Status{
	
	private int policyId;
	private LocalDate startDate;
	private LocalDate endDate;
	private double idv;
	private double premium;
	private double totalIdv;
	private String type;
	private String period;

	public String getPeriod() {
		return period;
	}
	
	public void setPeriod(String period) {
		this.period = period;
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getPolicyId() {
		return policyId;
	}
	
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
}
