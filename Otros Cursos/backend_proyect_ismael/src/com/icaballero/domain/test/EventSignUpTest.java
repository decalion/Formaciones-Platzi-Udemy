package com.icaballero.domain.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.icaballero.domain.EventSignUp;

/**
 * Test de los metodos de la clase singuptest
 * 
 * @author Ismael Caballero Hernadez
 *
 */
public class EventSignUpTest {

	private EventSignUp event;

	@Before
	public void setUp() throws Exception {
		event = new EventSignUp();
	}

	@After
	public void tearDown() throws Exception {
		event = null;
	}

	/**
	 * Testemos el Constructor
	 */
	@Test
	public void testEventSignUp() {
		EventSignUp e = new EventSignUp();
	}

	/**
	 * Testemos que ID se guarda correctamente
	 */
	@Test
	public void testSetId() {
		event.setId(1);
		assertEquals(1, event.getId());
	}

	/**
	 * Testeamos que el Id Visitor se guarda Correctamente
	 */
	@Test
	public void testSetIdVisitor() {
		event.setIdVisitor(1);
		assertEquals(1, event.getIdVisitor());
	}

	/**
	 * Testeamos que Id Event se Guarda Correctamente
	 */
	@Test
	public void testSetIdEvent() {
		event.setIdEvent(1);
		assertEquals(1, event.getIdEvent());
	}

}
