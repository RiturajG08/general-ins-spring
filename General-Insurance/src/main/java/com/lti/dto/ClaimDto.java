package com.lti.dto;

import java.time.LocalDate;

public class ClaimDto {
	
	private int pid;
	private LocalDate dateOfLoss;
	private String reason;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public LocalDate getDateOfLoss() {
		return dateOfLoss;
	}
	public void setDateOfLoss(LocalDate dateOfLoss) {
		this.dateOfLoss = dateOfLoss;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
