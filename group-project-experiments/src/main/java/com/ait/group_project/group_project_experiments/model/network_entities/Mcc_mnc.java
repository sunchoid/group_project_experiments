package com.ait.group_project.group_project_experiments.model.network_entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Mcc_mncKey.class)
public class Mcc_mnc implements Serializable, NetworkEntity {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "INT UNSIGNED", nullable = false)
	private int mcc;
	@Id
	@Column(columnDefinition = "INT UNSIGNED", nullable = false)
	private int mnc;
	@Column(nullable = false)
	private String country;
	@Column(nullable = false)
	private String operator;
	
	public Mcc_mnc() {}

	public Mcc_mnc(int mcc, int mnc, String country, String operator) {
		this.mcc = mcc;
		this.mnc = mnc;
		this.country = country;
		this.operator = operator;
	}

	public int getMcc() {
		return mcc;
	}

	public void setMcc(int mcc) {
		this.mcc = mcc;
	}

	public int getMnc() {
		return mnc;
	}

	public void setMnc(int mnc) {
		this.mnc = mnc;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
