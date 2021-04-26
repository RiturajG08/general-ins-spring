package com.lti.dto;

import java.time.LocalDate;

public class ClaimDto {
	
	private int pid;
	
	private String reason;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
