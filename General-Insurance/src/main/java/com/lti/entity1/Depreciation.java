package com.lti.entity1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="depreciation_tbl")
public class Depreciation {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="vehicle_age")
	private int vehicleAge;
	
	@Column(name="depreciation_percentage")
	private int percentage;
	
	@Column(name="depreciation_amount")
	private int depreciationAmount;
	
	@OneToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVehicleAge() {
		return vehicleAge;
	}

	public void setVehicleAge(int vehicleAge) {
		this.vehicleAge = vehicleAge;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public int getDepreciationAmount() {
		return depreciationAmount;
	}

	public void setDepreciationAmount(int depreciationAmount) {
		this.depreciationAmount = depreciationAmount;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	
}
