package com.ait.group_project.group_project_experiments.test;

import static org.junit.Assert.*;

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

import com.ait.group_project.group_project_experiments.model.EventCause;
import com.ait.group_project.group_project_experiments.model.Game;
import com.ait.group_project.group_project_experiments.model.ModelClass;
import com.ait.group_project.group_project_experiments.rest.NetworkDataService;

@RunWith(Arquillian.class)
public class ObjectPersistanceTest {
	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "object_test.war").addPackage(ModelClass.class.getPackage())
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
	            .addAsWebInfResource("jbossas-ds.xml")
	            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	private static final int[] CAUSE_CODES = {
			0, 1, 2
	    };
	private static final int[] EVENT_IDS = {
			4097, 4097, 4097
	};
	private static final String[] DESCRIPTIONS = {
			"RRC CONN SETUP-SUCCESS", "RRC CONN SETUP-UNSPECIFIED", "RRC CONN SETUP-FAILURE IN RADIO PROCEDURE"
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
        em.createQuery("delete from ModelClass").executeUpdate();
        utx.commit();
    }

    private void insertData() throws Exception {
        utx.begin();
        em.joinTransaction();
        System.out.println("Inserting records...");
       
        for (String description : DESCRIPTIONS) {
            	ModelClass object = new ModelClass();
            	object.setDescription(description);
            	em.persist(object);
        }
        utx.commit();
        // clear the persistence context (first-level cache)
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
    public void shouldFindDescriptiond() {
    	// given
        String fetchingAllObjectsInJpql = "select mc from ModelClass mc order by mc.id";

        // when
        System.out.println("Selecting (using JPQL)...");
        List<ModelClass> objects = em.createQuery(fetchingAllObjectsInJpql, ModelClass.class).getResultList();

        // then
        System.out.println("Found " + objects.size() + " objects (using JPQL):");
        assertEquals(3, objects.size());
    }
    
}
