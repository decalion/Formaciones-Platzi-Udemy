package com.icaballero.services.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.icaballero.domain.Event;
import com.icaballero.domain.Visitor;
import com.icaballero.services.VisitorService;

/**
 * Tests de la Clase VisitorService
 * 
 * @author Ismael Caballero
 *
 */
public class VisitorServiceTest {

	private VisitorService vService;

	@Before
	public void setUp() throws Exception {
		vService = new VisitorService();
	}

	@After
	public void tearDown() throws Exception {
		vService = null;
	}

	/**
	 * Test Constructor
	 */
	@Test
	public void testVisitorService() {
		VisitorService v = new VisitorService();
		Assert.assertNotNull(v);
	}

	/**
	 * Test CreateVisitor
	 */
	@Test
	public void testCreateVisitor() {
		Visitor visitor = new Visitor();
		visitor.setFirstName("pepe");
		visitor.setLastName("pepe");
		visitor.setDni("45858750Q");
		visitor.setEmail("adfg@gmail.com");
		visitor.setPhoneNumber("+34 123 456 789 99");
		visitor.setAddres("Carrer carrer 24");
		visitor.setUserName("pepe234");
		visitor.setPassword("345680");
		visitor.setAdmin(false);
		
		boolean status = vService.createVisitor(visitor);
		
		Assert.assertEquals(true, status);
	}

	/**
	 * Test SearchVisitor
	 */
	@Test
	public void testSearchVisitor() {
		Visitor visitor = new Visitor();
		visitor.setVisitorId(3);
		//visitor.setFirstName("pepe");
		/*visitor.setLastName("pepe");
		visitor.setDni("45858750Q");
		visitor.setEmail("adfg@gmail.com");
		visitor.setPhoneNumber("+34 123 456 789 99");
		visitor.setAddres("Carrer carrer 24");
		
		visitor.setPassword("345680");
		visitor.setAdmin(false);*/
		
		
		Visitor v = vService.searchVisitor(visitor);
		
		Assert.assertEquals(visitor, v);
	}

	/**
	 * Test ShowRegisterEvents
	 */
	@Test
	public void testShowRegisteredEvents() {
		Visitor v = new Visitor();
		v.setVisitorId(1);
		
		List<Event> list = vService.showRegisteredEvents(v);
		
		Assert.assertEquals(3, list.size());
	}

	/**
	 * Test UpdateEventsDetail
	 */
	@Test
	public void testUpdateVisitorDetails() {
		Visitor visitor = new Visitor();
		visitor.setVisitorId(4);
		visitor.setFirstName("juan");
		visitor.setLastName("juan");
		visitor.setDni("45858750Q");
		visitor.setEmail("adfg@gmail.com");
		visitor.setPhoneNumber("+34 193 496 709 99");
		visitor.setAddres("Carrer carrer 89");
		visitor.setUserName("juan456");
		visitor.setPassword("987456");
		visitor.setAdmin(false);
		
		int status = vService.updateVisitorDetails(visitor);
		
		Assert.assertEquals(1, status);
	}

	/**
	 * Test changePassword
	 */
	@Test
	public void testChangePassword() {
		Visitor visitor = new Visitor();
		visitor.setVisitorId(4);
		visitor.setPassword("7896546");
		
		int status = vService.changePassword(visitor);
		
		Assert.assertEquals(1, status);

	}

}
