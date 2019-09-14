package com.icaballero.daos.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.events.EventException;

import com.icaballero.daos.DAOManager;
import com.icaballero.daos.EventSignUpDAO;
import com.icaballero.domain.EventSignUp;
import com.icaballero.exceptions.DAOException;

/**
 * Test EventSingUpDAO
 * @author Ismael Caballero
 *
 */
public class EventSignUpDAOTest {
	
	private EventSignUpDAO singUpDAO;
	private DAOManager manager;
	

	@Before
	public void setUp() throws Exception {
		manager = new DAOManager();
		singUpDAO = (EventSignUpDAO) manager.getEventSingUpDAO();
	}

	@After
	public void tearDown() throws Exception {
		singUpDAO = null;
		manager.closeError();
	}

	/**
	 * Test constructor
	 */
	@Test
	public void testEventSignUpDAO() {
		singUpDAO = (EventSignUpDAO) manager.getEventSingUpDAO();
		Assert.assertNotNull(singUpDAO);
		
	}

	/**
	 * test metodo checkeventsoftvisitor
	 */
	@Test
	public void testCheckEventsofVisitor() {
		EventSignUp e = new EventSignUp();
		e.setId(1);
		e.setIdEvent(2);
		e.setIdVisitor(1);
		
		singUpDAO.checkEventsofVisitor(e);
	}

	/**
	 * Test metodo unregisterToEvent
	 */
	@Test
	public void testUnregisterVisitorToEvent() {
		EventSignUp e = new EventSignUp();
		e.setId(1);
		e.setIdEvent(2);
		e.setIdVisitor(1);
		
		singUpDAO.unregisterVisitorToEvent(e);
	}

	/**
	 * test metodo RegisterVisitorToEvent
	 */
	@Test
	public void testRegisterVisitorToEvent() {
		EventSignUp e = new EventSignUp();
		e.setId(8);
		e.setIdEvent(6);
		e.setIdVisitor(3);
		
		singUpDAO.registerVisitorToEvent(e);
	}

	/**
	 * Test Exception del metodo  RegisterVisitorToEvent
	 */
	@Test(expected = DAOException.class)
	public void testExceptionRegisterVisitorToEvent(){
		EventSignUp e = new EventSignUp();
		e.setId(6);
		e.setIdEvent(3);
		e.setIdVisitor(4);
		
		singUpDAO.registerVisitorToEvent(e);
	}

	
	/**
	 * test Metodo deleteEventSingUp
	 */
	@Test
	public void testDeleteEventSignUp() {
		EventSignUp e = new EventSignUp();
		e.setId(1);
		e.setIdEvent(2);
		e.setIdVisitor(1);
		
		singUpDAO.deleteEventSignUp(1);
	}
	
	/**
	 * Test Exception del metodo DleteEventsSingsUp
	 */
	@Test(expected = DAOException.class)
	public void testExceptionDeleteEventsSignUp(){
		EventSignUp e = new EventSignUp();
		e.setId(6);
		e.setIdEvent(2);
		e.setIdVisitor(1);
		
		singUpDAO.deleteEventSignUp(7);
	}

	/**
	 * test Metodo registeredEvents
	 */
	@Test
	public void testRegisteredEvents() {
		EventSignUp e = new EventSignUp();
		e.setId(8);
		e.setIdEvent(4);
		e.setIdVisitor(5);
		
		singUpDAO.registeredEvents(e);
	}

}
