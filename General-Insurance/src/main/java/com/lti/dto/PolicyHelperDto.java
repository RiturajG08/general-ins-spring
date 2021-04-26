package com.lti.dto;

import java.time.LocalDate;

public class PolicyHelperDto {

	private int cid;
	private int vid;
	private int did;
	private String type;
	private LocalDate startDate;
	private LocalDate endDate;
	private double premium;
	private double eachYearIdv;
	private double totalIdv;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
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
		
}
