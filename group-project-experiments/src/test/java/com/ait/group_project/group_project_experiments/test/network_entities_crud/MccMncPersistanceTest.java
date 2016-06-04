package com.ait.group_project.group_project_experiments.test.network_entities_crud;

import static org.junit.Assert.*;

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

import com.ait.group_project.group_project_experiments.model.network_entities.MccMncDAO;
import com.ait.group_project.group_project_experiments.model.network_entities.Mcc_mnc;

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
		assertEquals(2, mccMncList.size());
	}
	@Test
	public void daoObjectShouldRetrieveUpdateEntryById() {
		assertNotNull(mccMncDAO.getMccMncEntryById(238, 1));
		assertEquals(238, mccMncDAO.getMccMncEntryById(238, 1).getMcc());
		assertEquals(1, mccMncDAO.getMccMncEntryById(238, 1).getMnc());
		//update
		Mcc_mnc mccMncRef = mccMncDAO.getMccMncEntryById(238, 1);
		assertEquals("Denmark", mccMncRef.getCountry());
		mccMncRef.setCountry("Japan");
		mccMncDAO.updateMccMncEntry(mccMncRef);
		assertEquals("Japan", mccMncDAO.getMccMncEntryById(238, 1).getCountry());
		// delete
		mccMncRef = mccMncDAO.getMccMncEntryById(238, 2);
		mccMncDAO.deleteMccMncEntry(mccMncRef);
		assertNull(mccMncDAO.getMccMncEntryById(238, 2));
		
	}
}
