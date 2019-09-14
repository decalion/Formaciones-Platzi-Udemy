package com.icaballero.daos.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.icaballero.daos.DAOManager;
import com.icaballero.daos.VisitorDAO;
import com.icaballero.domain.Visitor;

/**
 * Test de EventDAO
 * @author Ismael Caballero
 *
 */
public class VisitorDAOTest {
	
	DAOManager manager;
	
	VisitorDAO visitorDAO;

	@Before
	public void setUp() throws Exception {
		manager = new DAOManager();
		visitorDAO = (VisitorDAO) manager.getVisitorDAO();
	}

	@After
	public void tearDown() throws Exception {
		visitorDAO = null;
		manager.closeError();
	}

	/**
	 * Test Constructor
	 */
	@Test
	public void testVisitorDAO() {
		VisitorDAO v = (VisitorDAO) manager.getVisitorDAO();
		Assert.assertNotNull(visitorDAO);
	}

	/**
	 * Test del metodo insertData
	 */
	@Test
	public void testInsertData() {
		Visitor visitor = new Visitor();
		visitor.setVisitorId(2);
		visitor.setFirstName("Ismael");
		visitor.setLastName("Caballero");
		visitor.setDni("45858750Q");
		visitor.setEmail("aaaa@gmail.com");
		visitor.setPhoneNumber("999 999 9999");
		visitor.setAddres("Carrer Vallirran");
		visitor.setUserName("ich245");
		visitor.setPassword("ich666");
		visitor.setAdmin(true);
		
		visitorDAO.insertData(visitor);
	}

	/**
	 * test del metodo searchUser
	 */
	@Test
	public void testSearchUser() {
		Visitor v = new Visitor();
		v.setUserName("pepe234");
		Visitor visitor = visitorDAO.searchUser(v);
		
		System.out.println(visitor.getFirstName()+" " +visitor.getLastName()+" "+visitor.getUserName()+" "
		+ visitor.getPassword());
	}

	/**
	 * Test del metodo updateVisitor
	 */
	@Test
	public void testUpdateVisitor() {
		Visitor visitor = new Visitor();
		visitor.setVisitorId(1);
		visitor.setFirstName("Ismael2");
		visitor.setLastName("Caballero2");
		visitor.setDni("45858750Q");
		visitor.setEmail("aaaa@gmail.com");
		visitor.setPhoneNumber("999 999 9999");
		visitor.setAddres("Carrer Vallirran2");
		visitor.setUserName("ich245");
		visitor.setPassword("ich666");
		visitor.setAdmin(true);
		
		visitorDAO.updateVisitor(visitor);
		
	}

	/**
	 * Test del metodo changePassword
	 */
	@Test
	public void testChangePassword() {
		Visitor visitor = new Visitor();
		visitor.setVisitorId(1);
		visitor.setPassword("klmo90");
		
		visitorDAO.changePassword(visitor);

	}

}
