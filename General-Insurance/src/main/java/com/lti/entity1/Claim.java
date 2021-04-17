package com.lti.entity1;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="claim_tbl")
public class Claim {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="date_of_loss")
	private LocalDate dateOfLoss;
	
	@Column(name="claim_date")
	private LocalDate claimDate;
	
	@Column(name="date_of_settlement")
	private LocalDate dateOfSettlement;
	
	private int amount;
	private String reason;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="policy_id")
	private Policy policy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateOfLoss() {
		return dateOfLoss;
	}

	public void setDateOfLoss(LocalDate dateOfLoss) {
		this.dateOfLoss = dateOfLoss;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public LocalDate getDateOfSettlement() {
		return dateOfSettlement;
	}

	public void setDateOfSettlement(LocalDate dateOfSettlement) {
		this.dateOfSettlement = dateOfSettlement;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	
}
