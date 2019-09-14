package com.icaballero.services.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.icaballero.domain.Event;
import com.icaballero.domain.Visitor;
import com.icaballero.services.EventService;

/**
 * Test de la Clase EventService
 * 
 * @author Ismael Caballero
 *
 */
public class EventServiceTest {
	private int i;
	private EventService eService;

	@Before
	public void setUp() throws Exception {
		eService = new EventService();
	}

	@After
	public void tearDown() throws Exception {
		switch(i){
			case 1: break;
		
		
			default : break;
		
		}
		eService = null;

	}

	/**
	 * Test Constructor
	 */
	@Test
	public void testEventService() {
		EventService service = new EventService();
		Assert.assertNotNull(service);
	}

	/**
	 * Test del metodo getAllEvents
	 */
	@Test
	public void testGetAllEvents() {
		List<Event> listEvent;
		listEvent = eService.getAllEvents();

		Assert.assertEquals("Evento 1", listEvent.get(0).getName());
	}

	/**
	 * Test metodo getAllEvent(event)
	 */
	@Test
	public void testGetAllEventsEvent() {
		List<Event> listEvent;
		Event evento = new Event();
		evento.setName("Evento 1");
		listEvent = eService.getAllEvents(evento);

		Assert.assertEquals("Evento 1", listEvent.get(0).getName());
	}

	/**
	 * Test metodo getEvent
	 */
	@Test
	public void testGetEvent() {
		Event evento = new Event();
		evento = eService.getEvent(1);

		Assert.assertEquals("Evento 1", evento.getName());
	}

	/**
	 * test updateEvent
	 */
	@Test
	public void testUpdateEvent() {
		Event evento = new Event();
		evento.setEventId(2);
		evento.setName("Evento 2");
		evento.setDescription("Evento 2");
		evento.setPlace("Place 2");
		evento.setDuration("1300-1800");
		evento.setEventType("Type 2");
		evento.setSeatsAEvent(101);

		int status = eService.updateEvent(evento);

		Assert.assertEquals(1, status);
	}

	/**
	 * Test DeleteEvent
	 */
	@Test
	public void testDeleteEvent() {
		this.i=1;
		int status = eService.deleteEvent(5);

		Assert.assertEquals(1, status);
	}

	/**
	 * Test metodo InsertEvent
	 */
	@Test
	public void testInsertEvent() {
		Event evento = new Event();
		evento.setName("Evento 3");
		evento.setDescription("Evento 3");
		evento.setPlace("Place 3");
		evento.setDuration("1300-1800");
		evento.setEventType("Type 3");
		evento.setSeatsAEvent(91);

		int status = eService.insertEvent(evento);

		Assert.assertEquals(1, status);
	}

	/**
	 * Test to UnrgisterEvents
	 */
	@Test
	public void testUnregisterEvent() {
		Visitor v = new Visitor();
		v.setVisitorId(7);
		
		Event e = new Event();
		e.setEventId(7);
		eService.unregisterEvent(v, e);

	}

	/**
	 * Test RegisterEventTovisitor
	 */
	@Test
	public void testRegisterEvent() {
		
		Visitor v = new Visitor();
		v.setVisitorId(4);
		
		Event e = new Event();
		e.setEventId(9);
		eService.registerEvent(v, e);
		
	}

}
