package com.icaballero.daos.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.icaballero.daos.DAOManager;
import com.icaballero.daos.SequencerDAO;

/**
 * 
 * @author Ismael Caballero
 *
 */
public class SequencerDAOTest {

	DAOManager  manager;
	SequencerDAO sequencerDAO;
	
	
	@Before
	public void setUp() throws Exception {
		manager = new DAOManager();
		sequencerDAO = (SequencerDAO) manager.getSequencerDAO();
	}

	@After
	public void tearDown() throws Exception {
		sequencerDAO = null;
		manager.closeError();
	}

	/**
	 * Test Constructor
	 */
	@Test
	public void testSequencerDAO() {
		sequencerDAO = (SequencerDAO) manager.getSequencerDAO();
		Assert.assertNotNull(sequencerDAO);
	}

	/**
	 * Test metodo getnext
	 */
	@Test
	public void testGetNext() {
	Assert.assertEquals(3, sequencerDAO.getNext("event"));
	}

}
