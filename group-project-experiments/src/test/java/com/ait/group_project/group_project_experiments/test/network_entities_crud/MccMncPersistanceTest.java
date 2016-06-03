package com.ait.group_project.group_project_experiments.test.network_entities_crud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ait.group_project.group_project_experiments.model.Base_data;
import com.ait.group_project.group_project_experiments.model.MccMncDAO;
import com.ait.group_project.group_project_experiments.model.Mcc_mnc;

@RunWith(Arquillian.class)
public class MccMncPersistanceTest {
	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "object_test.war").addPackage(Mcc_mnc.class.getPackage())
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml").addAsResource("import.sql")
	            .addAsWebInfResource("jbossas-ds.xml")
	            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	@EJB
	MccMncDAO mccMncDAO;
	
	@Test
	public void daoObjectShouldRetrieveAllEntries() {
		List<Mcc_mnc> mccMncList = mccMncDAO.getAllMccMncData();
		assertFalse(mccMncList.isEmpty());
		assertEquals(1, mccMncList.size());
	}
	@Test
	public void daoObjectShouldRetrieveEntryById() {
		
	}
}
