package com.lti.entity1;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="claim_tbl")
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_sequence")
	@SequenceGenerator(sequenceName="claim_seq", allocationSize=1, name="my_sequence")
	private int id;
	
	
	
	@Column(name="claim_date")
	private LocalDate claimDate;
	
	
	private int amount;
	private String reason;
	private String status;
	private String rejectionReason;
	
	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	@Column(name ="incident_photo")
	private String incidentPhoto;
	
	@ManyToOne
	@JoinColumn(name="policy_id")
	private Policy policy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
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
	
	public String getIncidentPhoto() {
		return incidentPhoto;
	}

	public void setIncidentPhoto(String incidentPhoto) {
		this.incidentPhoto = incidentPhoto;
	}

	
}
