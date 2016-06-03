package com.ait.group_project.group_project_experiments.model;

import java.io.Serializable;

public class Mcc_mncKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private int mcc;
	private int mnc;
	
	public int getUniqueIdentifier() {
		return this.mcc + this.mnc;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Mcc_mncKey) {
			Mcc_mncKey other = (Mcc_mncKey) object;
			return this.getUniqueIdentifier() == other.getUniqueIdentifier();
		}
		return false;
	}
	@Override
	public int hashCode() {
		String sumOfMccAndMnc = Integer.toString(this.getUniqueIdentifier());
		return sumOfMccAndMnc.hashCode();
	}
	
}
