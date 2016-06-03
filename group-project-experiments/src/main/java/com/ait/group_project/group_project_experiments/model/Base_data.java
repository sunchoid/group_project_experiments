package com.ait.group_project.group_project_experiments.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Base_data implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT UNSIGNED")
	private int report_id;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date_time;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns(
		{@JoinColumn(name="cause_code", referencedColumnName="cause_code", nullable = true),
		@JoinColumn(name="event_id", referencedColumnName="event_id")}
		)
	private EventCause eventCause;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="failure_class", referencedColumnName="failure_class", nullable = true)
	private Failure_class failureClass;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ue_type", referencedColumnName="tac")
	private User_equipment userEquipment;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns( 
		{@JoinColumn(name="market", referencedColumnName="mcc"),
		@JoinColumn(name="operator", referencedColumnName="mnc")}
			)
	private Mcc_mnc mccMnc;
	@Column(columnDefinition = "INT UNSIGNED", nullable = false)
	private int cell_id;
	@Column(columnDefinition = "INT UNSIGNED", nullable = false)
	private int duration;
	@Column(nullable = false)
	private String ne_version;
	@Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
	private BigInteger imsi;
	@Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
	private BigInteger hier3_id;
	@Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
	private BigInteger hier32_id;
	@Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
	private BigInteger hier321_id;
	
	public EventCause getEventCause() {
		return eventCause;
	}

	public void setEventCause(EventCause eventCause) {
		this.eventCause = eventCause;
	}

	public Failure_class getFailureClass() {
		return failureClass;
	}

	public void setFailureClass(Failure_class failureClass) {
		this.failureClass = failureClass;
	}

	public User_equipment getUserEquipment() {
		return userEquipment;
	}

	public void setUserEquipment(User_equipment userEquipment) {
		this.userEquipment = userEquipment;
	}

	public Mcc_mnc getMccMnc() {
		return mccMnc;
	}

	public void setMccMnc(Mcc_mnc mccMnc) {
		this.mccMnc = mccMnc;
	}

	public Base_data() {}
	
	public Base_data(Calendar date_time, int cause_code, int event_id,
			int failure_class, int ue_type, int market, int operator,
			int cell_id, int duration, String ne_version, BigInteger imsi,
			BigInteger hier3_id, BigInteger hier32_id, BigInteger hier321_id) {
		this.date_time = date_time;
		


		this.cell_id = cell_id;
		this.duration = duration;
		this.ne_version = ne_version;
		this.imsi = imsi;
		this.hier3_id = hier3_id;
		this.hier32_id = hier32_id;
		this.hier321_id = hier321_id;
	}



	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public Calendar getDate_time() {
		return date_time;
	}
	public void setDate_time(Calendar date_time) {
		this.date_time = date_time;
	}
	public int getCell_id() {
		return cell_id;
	}
	public void setCell_id(int cell_id) {
		this.cell_id = cell_id;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getNe_version() {
		return ne_version;
	}
	public void setNe_version(String ne_version) {
		this.ne_version = ne_version;
	}
	public BigInteger getImsi() {
		return imsi;
	}
	public void setImsi(BigInteger imsi) {
		this.imsi = imsi;
	}
	public BigInteger getHier3_id() {
		return hier3_id;
	}
	public void setHier3_id(BigInteger hier3_id) {
		this.hier3_id = hier3_id;
	}
	public BigInteger getHier32_id() {
		return hier32_id;
	}
	public void setHier32_id(BigInteger hier32_id) {
		this.hier32_id = hier32_id;
	}
	public BigInteger getHier321_id() {
		return hier321_id;
	}
	public void setHier321_id(BigInteger hier321_id) {
		this.hier321_id = hier321_id;
	}
	
	
}
