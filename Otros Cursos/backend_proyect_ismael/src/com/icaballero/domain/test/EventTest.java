package com.icaballero.domain.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.icaballero.domain.Event;
import com.icaballero.exceptions.DomainException;

/**
 * Test de los metodos de la clase Event
 * 
 * @author Ismael Caballero
 *
 */
public class EventTest {

	private Event event;

	@Before
	public void setUp() throws Exception {
		event = new Event();
	}

	@After
	public void tearDown() throws Exception {
		event = null;
	}

	/**
	 * Test Constructor event correcto
	 */
	@Test
	public void testEvent() {
		Event event = new Event();
	}

	/**
	 * Test Constructor copia event, copia correcta y no null
	 */
	@Test
	public void testEventEvent() {
		event.setEventId(1);
		event.setName("Ismael");
		event.setDescription("Me llamo Ismael");
		event.setPlace("Palau Sant Jorid");
		event.setDuration("3 dias");
		event.setEventType("Musica");
		event.setSeatsAEvent(45);

		Event e = new Event(event);

		assertEquals(event, e);

		Event ee = new Event(null);

	}

	/**
	 * Test setname correcto
	 */
	@Test
	public void testSetName() {
		event.setName("Ismael");
		assertEquals("Ismael", event.getName());
	}

	/**
	 * test setname longitud incorrecta y no null
	 */
	@Test(expected = DomainException.class)
	public void testSetNameLongitud() {
		event.setName("");
		event.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		event.setName(null);
	}

	/**
	 * Test setdescription correcto
	 */
	@Test
	public void testSetDescription() {
		event.setDescription("Me llamo Ismael");
		assertEquals("Me llamo Ismael", event.getDescription());
	}

	/**
	 * test setdescription longitud incorrecta
	 */
	@Test(expected = DomainException.class)
	public void testSetDesciptionLongitud() {
		event.setDescription("");
		event.setDescription("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		event.setDescription(null);
	}

	/**
	 * test setplace correcto
	 */
	@Test
	public void testSetPlace() {
		event.setPlace("Palau Sant Jordi");
		assertEquals("Palau Sant Jordi", event.getPlace());
	}

	/**
	 * test setplace longitud incorrecta
	 */
	@Test(expected = DomainException.class)
	public void testSetPlaceLongitud() {
		event.setPlace("");
		event.setPlace("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		event.setPlace(null);
	}

	/**
	 * test setduratuion correcto
	 */
	@Test
	public void testSetDuration() {
		event.setDuration("3 dias");
		assertEquals("3 dias", event.getDuration());
	}

	/**
	 * test setduration incorrecta.
	 */
	@Test(expected = DomainException.class)
	public void testSetDurationLongitud() {
		event.setDuration("");
		event.setDuration("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		event.setDuration(null);
	}

	/**
	 * test seteventtype correcto
	 */
	@Test
	public void testSetEventType() {
		event.setEventType("Musica");
		assertEquals("Musica", event.getEventType());
	}

	/**
	 * test seteventtye longitud incorrecta
	 */
	@Test(expected = DomainException.class)
	public void testSetEventTypeLongitud() {
		event.setEventType("");
		event.setEventType("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		event.setEventType(null);
	}

	/**
	 * test setseatsaevent correcto
	 */
	@Test
	public void testSetSeatsAEvent() {
		event.setSeatsAEvent(45);
		assertEquals(45, event.getSeatsAEvent());
	}

	/**
	 * test setseataevent negatico incorrecto
	 */
	@Test(expected = DomainException.class)
	public void testSetseatsAvaliableNegativo() {
		event.setSeatsAEvent(-6);
	}

	/**
	 * test seteeventid correcto
	 */
	@Test
	public void testsetEventId() {
		event.setEventId(1);
		assertEquals(1, event.getEventId());

	}

}
