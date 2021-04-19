package com.lti.entity1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="depreciation_tbl")
public class Depreciation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_sequence")
	@SequenceGenerator(sequenceName="depreciation_seq", allocationSize=1, name="my_sequence")
	private int id;
	
	@Column(name="vehicle_age")
	private long vehicleAge;
	
	@Column(name="depreciation_percentage")
	private int percentage;
	
	@Column(name="depreciation_amount")
	private double depreciationAmount;
	
	@OneToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getVehicleAge() {
		return vehicleAge;
	}

	public void setVehicleAge(long vehicleAge) {
		this.vehicleAge = vehicleAge;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public double getDepreciationAmount() {
		return depreciationAmount;
	}

	public void setDepreciationAmount(double depreciationAmount) {
		this.depreciationAmount = depreciationAmount;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	
}
