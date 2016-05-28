package com.ait.group_project.group_project_experiments.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ModelClass implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String description;
	@Id @GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(nullable = false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override 
	public String toString() {
		return "Object@" + hashCode() + "[id = " + id + "; title = " + description + "]";
	}
}
