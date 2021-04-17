package com.lti.entity1;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_tbl")
public class Vehicle {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="vehicle_type")
	private String type;
	
	@Column(name="vehicle_number")
	private String number;
	
	private int price;
	
	@Column(name="engine_number")
	private String engineNumber;
	
	@Column(name="registration_date")
	private LocalDate registrationDate;
	
	@Column(name="driving_license")
	private String drivingLicense;
	
	@Column(name="chasis_number")
	private String chassisNumber;
	
	private String model;
	private String manufacturer;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	@OneToOne(mappedBy= "vehicle")
	private Policy policy;

	@OneToOne(mappedBy= "vehicle")
	private Depreciation depreciation;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Depreciation getDepreciation() {
		return depreciation;
	}

	public void setDepreciation(Depreciation depreciation) {
		this.depreciation = depreciation;
	}

}
