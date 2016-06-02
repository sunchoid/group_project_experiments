package com.ait.group_project.group_project_experiments.model;

public enum RecordFormat {
	SEVEN_INCH("seven_inch"), 
	TEN_INCH("ten_inch"), 
	TWELVE_INCH("twelve_inch");
	
	private String recordFormat;
	private RecordFormat(String recordFormat) {
		this.setRecordFormat(recordFormat);
	}
	public String getRecordFormat() {
		return recordFormat;
	}
	public void setRecordFormat(String recordFormat) {
		this.recordFormat = recordFormat;
	}
}
