package com.ait.group_project.group_project_experiments.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

@Stateless
@LocalBean
public class MccMncDAO {
	@PersistenceContext
    private EntityManager entityManager;
	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<Mcc_mnc> criteria;
	
	public List<Mcc_mnc> getAllMccMncData() {
		Root<Mcc_mnc> mccMncEntry = getRootCriteria();
		criteria.select(mccMncEntry).orderBy(criteriaBuilder.asc(mccMncEntry.get("mcc")));
		return entityManager.createQuery(criteria).getResultList();
	}
	public Mcc_mnc getMccMncEntryById(Mcc_mncKey mccMncKey) {
		Root<Mcc_mnc> mccMncEntry = getRootCriteria();
		ParameterExpression<Mcc_mncKey> parameter = criteriaBuilder.parameter(Mcc_mncKey.class);
		criteria.select(mccMncEntry).where(criteriaBuilder.equal(mccMncEntry.get("mcc").get("mnc"), mccMncKey));
		return entityManager.createQuery(criteria).getSingleResult();
		
	}
	public Root<Mcc_mnc> getRootCriteria() {
		criteriaBuilder = entityManager.getCriteriaBuilder();
		criteria = criteriaBuilder.createQuery(Mcc_mnc.class);
		Root<Mcc_mnc> mccMncCriteria = criteria.from(Mcc_mnc.class);
		return mccMncCriteria;
	}
	
	

}
