package com.ait.group_project.group_project_experiments.model;

import java.io.Serializable;

public class EventCauseKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private int cause_code;
	private int event_id;
	
	public int getUniqueIdentifier() {
		return this.cause_code + this.event_id;
	}
	@Override
	public boolean equals(Object object) {
		if(object instanceof EventCauseKey) {
			EventCauseKey other = (EventCauseKey) object;
			return this.getUniqueIdentifier() == other.getUniqueIdentifier();
		}
		return false;
	}
	@Override 
	public int hashCode() {
		String sumOfCauseAndEvent = Integer.toString(this.getUniqueIdentifier());
		return sumOfCauseAndEvent.hashCode();
	}
}
