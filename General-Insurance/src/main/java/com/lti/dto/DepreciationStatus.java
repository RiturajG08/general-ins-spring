package com.lti.dto;

import java.time.LocalDate;

public class DepreciationStatus extends Status{
	
	private int price;
	private LocalDate registrationDate;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
	

}
