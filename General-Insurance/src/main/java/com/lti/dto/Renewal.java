package com.lti.dto;

public class Renewal {
 private int id;
 
 private String number;
  private String type;
  private String period;
  
  

public String getPeriod() {
	return period;
}

public void setPeriod(String period) {
	this.period = period;
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
}
