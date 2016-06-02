package com.ait.group_project.group_project_experiments.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="event_cause")
@IdClass(EventCauseKey.class)
public class EventCause implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "INT UNSIGNED", nullable = false)
	private int cause_code;
	@Id
	@Column(columnDefinition = "INT UNSIGNED", nullable = false)
	private int event_id;
	@Column(nullable = false)
	private String description;
	
	public EventCause() {
		
	}
	public EventCause(int causeCode, int eventId, String description) {
		cause_code = causeCode;
		event_id = eventId;
		this.description = description;
	}
	
	public int getCause_code() {
		return cause_code;
	}
	public void setCause_code(int cause_code) {
		this.cause_code = cause_code;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Event_Cause: cause code: " + cause_code + " event id: " + event_id + " description: " + description;
	}

}
