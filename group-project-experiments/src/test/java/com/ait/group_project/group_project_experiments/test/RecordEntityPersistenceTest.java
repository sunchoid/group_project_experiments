package com.ait.group_project.group_project_experiments.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ait.group_project.group_project_experiments.model.Record;
import com.ait.group_project.group_project_experiments.model.RecordFormat;
import com.ait.group_project.group_project_experiments.model.network_entities.EventCause;

@RunWith(Arquillian.class)
public class RecordEntityPersistenceTest {
	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "object_test.war").addPackage(Record.class.getPackage())
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
	            .addAsWebInfResource("jbossas-ds.xml")
	            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	private static final String[] ARTISTS = {
			"T.S.O.L.", "D.I."
	    };
	private static final String[] TITLES = {
			"Weathered Statues", "D.I./self-titled"
	};
	private static final RecordFormat[] FORMATS = {
			RecordFormat.TWELVE_INCH, RecordFormat.TWELVE_INCH
	};
	private static final String[] YEARS = {
			"1982", "1983"
	};
	private static final String[] COUNTRIES = {
			"USA", "USA"
	};
	private static final String[] LABELS = {
			"Alternative Tentacles", "Revenge Records"
	};
	private static final String[] PRESSINGS = {
			"1st pressing", "1st pressing"
	};
	private static final String[] CONDITIONS = {
			"Media: VG+/Sleeve: NM", "Media: NM/Sleeve: VG+"
	};
	@PersistenceContext
    EntityManager em;
    
    @Inject
    UserTransaction utx;
       
    @Before
    public void preparePersistenceTest() throws Exception {
        clearData();
        insertData();
        startTransaction();
    }
    private void clearData() throws Exception {
        utx.begin();
        em.joinTransaction();
        System.out.println("Dumping old records...");
        em.createQuery("delete from Record").executeUpdate();
        utx.commit();
    }

    private void insertData() throws Exception {
        utx.begin();
        em.joinTransaction();
        System.out.println("Inserting records...");
        for(int j = 0; j < 2; j++) {
        		Record record = new Record();
        		record.setArtist(ARTISTS[j]);
        		record.setTitle(TITLES[j]);
        		record.setRecord_format(FORMATS[j]);
        		record.setCountry(COUNTRIES[j]);
        		record.setLabel(LABELS[j]);
        		record.setRelease_year(YEARS[j]);
        		record.setPressing(PRESSINGS[j]);
        		record.setRecord_condition(CONDITIONS[j]);
        		em.persist(record);
        }
        utx.commit();
        em.clear();
    }
    private void startTransaction() throws Exception {
        utx.begin();
        em.joinTransaction();
    }
    @After
    public void commitTransaction() throws Exception {
        utx.commit();
    }
    @Test
    public void shouldFindRecordObjects() {
    	
        String fetchingAllRecordsInJpql = "select r from Record r order by r.id";
        List<Record> records = em.createQuery(fetchingAllRecordsInJpql, Record.class).getResultList();
        
        System.out.println("Found " + records.size() + " objects (using JPQL):");
        assertEquals(2, records.size());
    }
    @Test
    public void shouldDeleteRecordObjectFromDB() {
    	String fetchingAllRecordsInJpql = "select r from Record r order by r.id";
        List<Record> records = em.createQuery(fetchingAllRecordsInJpql, Record.class).getResultList();
        Record record = records.get(0);
        System.out.println("Removing the following record from the DB:");
        record.toString();
        em.remove(record);
        records = em.createQuery(fetchingAllRecordsInJpql, Record.class).getResultList();
        System.out.println("Found " + records.size() + " objects (using JPQL):");
        assertEquals(1, records.size());
    }
    @Test
    public void shouldUpdateARecord() {
    	String fetchingAllRecordsInJpql = "select r from Record r order by r.id";
        List<Record> records = em.createQuery(fetchingAllRecordsInJpql, Record.class).getResultList();
        Record record = records.get(0);
        System.out.println("Updating a record");
        record.setArtist("Black Flag");
        em.merge(record);
        records = em.createQuery(fetchingAllRecordsInJpql, Record.class).getResultList();
        record = records.get(0);
        assertEquals("Black Flag", record.getArtist());
    }
    
}
