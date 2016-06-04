package com.ait.group_project.group_project_experiments.model.network_entities;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
//import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

@Stateless
@LocalBean
public class BaseDataDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<Base_data> criteria;
	
	
	public List<Base_data> getAllBaseDataReports() {
		Root<Base_data> baseDataReport = getRootCriteria();
    	criteria.select(baseDataReport).orderBy(criteriaBuilder.asc(baseDataReport.get("report_id")));
    	return entityManager.createQuery(criteria).getResultList();
    }
	public Base_data getBaseDataReportById(int reportId) {
		Root<Base_data> baseDataReport = getRootCriteria();
		ParameterExpression<Integer> parameter = criteriaBuilder.parameter(Integer.class);
		criteria.select(baseDataReport).where(criteriaBuilder.equal(baseDataReport.get("report_id"), reportId));
		return entityManager.createQuery(criteria).getSingleResult();
	}
	public void delete(Base_data baseData) {
		entityManager.remove(entityManager.contains(baseData) ? baseData : entityManager.merge(baseData));
	}
//	public void deleteBaseDataReportUsingCriteria(Base_data baseData) {
//		CriteriaDelete<Base_data> criteriaDelete = criteriaBuilder.createCriteriaDelete(Base_data.class);
//		Root<Base_data> baseDataReport = criteriaDelete.from(Base_data.class);
//		criteriaDelete.where(criteriaBuilder.equal(baseDataReport.get("report_id"), baseData.getReport_id()));
//		entityManager.createQuery(criteriaDelete).executeUpdate();
//	}
	public void updateBaseDataReport(Base_data baseData) {
		entityManager.merge(baseData);
		
	}
	public Root<Base_data> getRootCriteria() {
		criteriaBuilder = entityManager.getCriteriaBuilder();
		criteria = criteriaBuilder.createQuery(Base_data.class);
		Root<Base_data> baseData = criteria.from(Base_data.class);
		return baseData;
	}
	

}
