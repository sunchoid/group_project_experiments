package com.ait.group_project.group_project_experiments.model.network_entities;

import java.io.Serializable;

public class Mcc_mncKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private int mcc;
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
