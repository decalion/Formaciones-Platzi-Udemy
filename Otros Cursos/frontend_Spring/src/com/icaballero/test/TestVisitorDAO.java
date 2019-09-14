package com.icaballero.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icaballero.dao.VisitorDAO;
import com.icaballero.entity.Event;
import com.icaballero.entity.Visitor;

/**
 * JUNIT test class for VisitorDAO class
 *
 */

/** Adding @ContextConfiguration for it to pick up context mappings */
@ContextConfiguration(locations = "classpath:/testApplicationContext.xml")
/** Adding @RunWith to indicate that the class should use Spring's JUnit facilities */
@RunWith(SpringJUnit4ClassRunner.class)
/** Adding @Transactional to use transaction capabilities without having to use begin, commit etc. */
@Transactional
/** Adding @Component to make TestEventDAO as a component and to initiate Spring Dependency Injection */
@Component
public class TestVisitorDAO {

	/** Adding @Autowired to inject VisitorDAO instance */
	@Autowired
	private VisitorDAO visitorDAO;

	@PersistenceContext
	EntityManager entityManager;

	private Visitor visitor;
	private ArrayList<Event> registeredEvents;

	/**
	 * Setting up initial objects
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		visitor = new Visitor();
		registeredEvents = new ArrayList<Event>();
	}

	/**
	 * Deallocating objects after execution of every method
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		visitor = null;
		registeredEvents = null;
	}

	/**
	 * insertData() is created to insert some test data only for testing
	 * purpose. This data, in the end will get rolled back and will have no
	 * impact on the database
	 */

	public void insertData() {
		visitor = new Visitor();
		visitor.setUserName("TestVisitor");
		visitor.setFirstName("TestVFname");
		visitor.setLastName("TestVLname");
		visitor.setPassword("ttt");
		visitor.setPhoneNumber("2344");
		visitor.setAddress("TestPlace");
		visitorDAO.insertData(visitor);

	}

	public void registerVisitorToEvent() {

		insertData();
		visitor = visitorDAO.searchUser("TestVisitor", "ttt");
		visitorDAO.registerVisitorToEvent(visitor, 1002);

	}

	/**
	 * Positive Test case for method insertData
	 */

	@Test
	public void testInsertData_Positive() {

		visitor.setUserName("TestVisitor");
		visitor.setFirstName("TestVFname");
		visitor.setLastName("TestVLname");
		visitor.setPassword("ttt");
		visitor.setPhoneNumber("2344");
		visitor.setAddress("TestPlace");
		assertTrue(visitorDAO.insertData(visitor));

	}

	/**
	 * Negative Test case for method insertData
	 */

	@Test
	public void testInsertData_Negative() {

		insertData();
		visitor.setUserName("TestVisitor");
		visitor.setFirstName("TestVFname");
		visitor.setLastName("TestVLname");
		visitor.setPassword("ttt");
		visitor.setPhoneNumber("2344");
		visitor.setAddress("TestPlace");
		assertFalse(visitorDAO.insertData(visitor));

	}

	/**
	 * Positive Test case for method searchUser
	 */

	@Test
	public void testSearchUser_Positive() {
		insertData();
		visitor = visitorDAO.searchUser("TestVisitor", "ttt");
		assertEquals(true, visitor.getUserName().equals("TestVisitor"));

	}

	/**
	 * Negative Test case for method searchUser
	 */

	@Test
	public void testSearchUser_Negative() {
		try {

			visitor = visitorDAO.searchUser("TestVisitor1", "ttt");
		} catch (NoResultException exception) {
			assertEquals("No rows found", exception.getMessage());
		}

	}

	/**
	 * Positive Test case for method registerVisitorToEvent
	 */
	@Test
	public void testRegisterVisitorToEvent_Positive() {
		try {
			visitor = visitorDAO.searchUser("bsmith", "password");
			visitorDAO.registerVisitorToEvent(visitor, 1003);

		} catch (Exception exception) {
			fail("Exception !!!");
		}
	}

	/**
	 * Negative Test case for method registerVisitorToEvent
	 */

	@Test
	public void testRegisterVisitorToEvent_Negative() {
		try {
			registerVisitorToEvent();
			visitor = visitorDAO.searchUser("TestVisitor", "ttt");
			visitorDAO.registerVisitorToEvent(visitor, 1002);

		} catch (Exception exception) {

			assertTrue(true);
		}
	}

	/**
	 * Positive Test case for method registeredEvents
	 */

	@Test
	public void testRegisteredEvents_Positive() {

		List<Object[]> registeredEvents = new ArrayList<Object[]>();

		visitor = visitorDAO.searchUser("bsmith", "password");

		registeredEvents = visitorDAO.registeredEvents(visitor);

		assertTrue(registeredEvents.size() >= 1);
	}

	/**
	 * Negative Test case for method registeredEvents
	 */

	@Test
	public void testRegisteredEvents_Negative() {

		Visitor visitor = new Visitor();
		List<Object[]> registeredEvents = visitorDAO.registeredEvents(visitor);

		assertTrue(registeredEvents.size() == 0);
	}

	/**
	 * Positive Test case for method updateVisitor
	 */

	@Test
	public void testUpdateVisitor_Positive() {
		int updateStatus = 0;

		insertData();
		visitor = visitorDAO.searchUser("TestVisitor", "ttt");
		visitor.setFirstName("NewTestName");
		updateStatus = visitorDAO.updateVisitor(visitor);
		assertEquals(1, updateStatus);
	}

	/**
	 * Negative Test case for method updateVisitor
	 */

	@Test
	public void testUpdateVisitor_Negative() {
		int updateStatus = 0;

		Visitor v = new Visitor();
		try {
			updateStatus = visitorDAO.updateVisitor(visitor);
		} catch (PersistenceException e) {
			assertEquals("Update visitor failed", e.getMessage());
		}
		assertEquals(0, updateStatus);
	}

	/**
	 * Positive Test case for method UnregisterEvent
	 */

	@Test
	public void testUnregisterEvent_Positive() {

		visitor = visitorDAO.searchUser("bsmith", "password");
		visitorDAO.registerVisitorToEvent(visitor, 1001);

		try {

			visitorDAO.unregisterEvent(visitor, 1002);
		} catch (Exception exception) {
			fail("Exception");
		}
	}

	/**
	 * Negative Test case for method UnregisterEvent
	 */

	@Test
	public void testUnregisterEvent_Negative() {

		visitor = visitorDAO.searchUser("bsmith", "password");


		try {

			visitorDAO.unregisterEvent(visitor, 0000);
		} catch (NoResultException exception) {
			assertTrue(true);
		}

	}

	/**
	 * Positive Test case for method changePassword
	 */

	@Test
	public void testChangePassword_Positive() {
		Visitor v = new Visitor();
		v.setVisitorId(1001);
		v.setUserName("bsmith");
		v.setPassword("NewPassword");

		int flag = visitorDAO.changePassword(v);
		assertTrue(flag == 1);

	}

	/**
	 * Negative Test case for method changePassword
	 */

	@Test
	public void testChangePassword_Negative() {
		Visitor v = new Visitor();
		v.setVisitorId(1001);
		v.setUserName("bsmith");
		v.setPassword("Password");

		int flag = visitorDAO.changePassword(v);
		assertTrue(flag == 0);

	}

	/**
	 * Positive Test case for method searchVisitor
	 */

	@Test
	public void testSearchVisitor_Positive() {
		boolean flag = visitorDAO.searchVisitor("bsmith");
		assertTrue(flag);

	}

	/**
	 * Positive Test case for method searchVisitor
	 */

	@Test
	public void testSearchVisitor_Negative() {
		boolean flag = visitorDAO.searchVisitor("NonExistingUser");
		assertFalse(flag);

	}

}
