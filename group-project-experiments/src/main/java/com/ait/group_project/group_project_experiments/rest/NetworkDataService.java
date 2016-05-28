package com.ait.group_project.group_project_experiments.rest;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.ait.group_project.group_project_experiments.model.EventCause;
import com.ait.group_project.group_project_experiments.model.ModelClass;

@Stateless
@LocalBean
public class NetworkDataService {
	
	@Inject
	private EntityManager entityManager;
	
	public void createDataEntry(EventCause eventCause) {
		entityManager.persist(eventCause);
	}
	public void createDataEntry(ModelClass modelClass) {
		entityManager.persist(modelClass);
	}

}
