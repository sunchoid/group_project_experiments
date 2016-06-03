package com.ait.group_project.group_project_experiments.test.network_entities_crud;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ait.group_project.group_project_experiments.model.BaseDataDAO;
import com.ait.group_project.group_project_experiments.model.Base_data;

@RunWith(Arquillian.class)
public class BaseDataPersistenceTest {
	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "object_test.war").addPackage(Base_data.class.getPackage())
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml").addAsResource("import.sql")
	            .addAsWebInfResource("jbossas-ds.xml")
	            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	@EJB
	BaseDataDAO baseDataDAO;
	
	@Test
	public void daoObjectShouldRetrieveAllBaseDataObjects() {
		// get all objects
		List<Base_data> baseDataList = baseDataDAO.getAllBaseDataReports();
		assertFalse(baseDataList.isEmpty());
		assertEquals(1, baseDataList.size());
		// update
		assertEquals(4, baseDataDAO.getAllBaseDataReports().get(0).getCell_id());
		Base_data baseData = baseDataDAO.getAllBaseDataReports().get(0);
		baseData.setCell_id(6);
		baseDataDAO.updateBaseDataReport(baseData);
		// get by id
		baseData = baseDataDAO.getBaseDataReportById(1);
		assertNotNull(baseData);
		assertEquals(1, baseData.getReport_id());
		assertEquals(6, baseData.getCell_id());
		// delete
		baseDataDAO.delete(baseDataDAO.getAllBaseDataReports().get(0));
		assertTrue(baseDataDAO.getAllBaseDataReports().isEmpty());
	}	
}
