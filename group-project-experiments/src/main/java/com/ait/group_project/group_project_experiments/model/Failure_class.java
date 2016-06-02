package com.ait.group_project.group_project_experiments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Failure_class {
	
	@Id
	@Column(columnDefinition = "INT UNSIGNED", nullable = false)
	private int failure_class;
	@Column(nullable = false)
	private String description;
	
	public Failure_class() {}
	
	public Failure_class(int failure_class, String description) {
		this.failure_class = failure_class;
		this.description = description;
	}

	public int getFailure_class() {
		return failure_class;
	}
	public void setFailure_class(int failure_class) {
		this.failure_class = failure_class;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
