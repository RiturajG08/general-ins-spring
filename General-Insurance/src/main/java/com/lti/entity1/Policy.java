package com.lti.entity1;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="policy_tbl")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_sequence")
	@SequenceGenerator(sequenceName="policy_seq", allocationSize=1, name="my_sequence")
	private int id;
	
	@Column(name="policy_type")
	private String type;
	
	@Column(name="policy_start_date")
	private LocalDate policyStartDate;
	
	@Column(name="policy_end_date")
	private LocalDate policyEndDate;
	
	private String period;
	private double premium;
	
	@Column(name="each_year_idv")
	private double eachYearIdv;
	
	@Column(name="total_idv")
	private double totalIdv;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	@OneToMany(cascade= CascadeType.ALL , mappedBy= "policy")
	private List<Claim> claims;

	@OneToOne
	@JoinColumn(name="depreciation_id")
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

	public LocalDate getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(LocalDate policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public LocalDate getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(LocalDate policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}
	
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public Depreciation getDepreciation() {
		return depreciation;
	}

	public void setDepreciation(Depreciation depreciation) {
		this.depreciation = depreciation;
	}
	
}
