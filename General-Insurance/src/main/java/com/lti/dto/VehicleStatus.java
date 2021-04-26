package com.lti.dto;

public class VehicleStatus extends Status{

	private int did;
	private int registerVehicleId;
	private String vehicleNumber;
	private double idv;
	private double depreciationAmount;

	public int getRegisterVehicleId() {
		return registerVehicleId;
	}

	public void setRegisterVehicleId(int registerVehicleId) {
		this.registerVehicleId = registerVehicleId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public double getIdv() {
		return idv;
	}

	public void setIdv(double idv) {
		this.idv = idv;
	}

	public double getDepreciationAmount() {
		return depreciationAmount;
	}

	public void setDepreciationAmount(double depreciationAmount) {
		this.depreciationAmount = depreciationAmount;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}
		
}
