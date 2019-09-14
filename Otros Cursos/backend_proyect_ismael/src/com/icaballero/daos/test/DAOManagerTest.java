package com.icaballero.daos.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.icaballero.daos.DAOManager;
import com.icaballero.daos.EventDAO;
import com.icaballero.daos.EventSignUpDAO;
import com.icaballero.daos.SequencerDAO;
import com.icaballero.daos.VisitorDAO;

/**
 * Test DAOManager
 * @author Ismael Caballero
 *
 */
public class DAOManagerTest {
	
	private DAOManager manager;

	@Before
	public void setUp() throws Exception {
		manager = new DAOManager();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test Constructor
	 */
	@Test
	public void testDAOManager() {
		DAOManager test = new DAOManager();
		Assert.assertNotNull(test);
	}

	/**
	 * Test Metodo getEventDAO
	 */
	@Test
	public void testGetEventDAO() {
		EventDAO event = (EventDAO) manager.getEventDAO();
		Assert.assertNotNull(event);
	}

	/**
	 * Test Metodo getVisitorDAO
	 */
	@Test
	public void testGetVisitorDAO() {
		VisitorDAO visitor = (VisitorDAO) manager.getVisitorDAO();
		Assert.assertNotNull(visitor);
	}

	/**
	 * Test metodo getEventSingUpDAO
	 */
	@Test
	public void testGetEventSingUpDAO() {
		EventSignUpDAO eventSingUp = (EventSignUpDAO) manager.getEventSingUpDAO();
		Assert.assertNotNull(eventSingUp);
	}

	/**
	 * test metodo getSequencerDAO
	 */
	@Test
	public void testGetSequencerDAO() {
		SequencerDAO sequencer = (SequencerDAO) manager.getSequencerDAO();
		Assert.assertNotNull(sequencer);
	}



}
