package com.icaballero.daos.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.icaballero.daos.DAOManager;
import com.icaballero.daos.EventDAO;
import com.icaballero.domain.Event;
import com.icaballero.exceptions.DAOException;

/**
 * Test de la clase EventDAO
 * @author Ismael Caballero
 *
 */
public class EventDAOTest {
	private EventDAO eventDAO;
	private DAOManager manager;

	@Before
	public void setUp() throws Exception {
		manager = new DAOManager();
		eventDAO = (EventDAO) manager.getEventDAO();
	}

	@After
	public void tearDown() throws Exception {
		eventDAO = null;
		manager.closeError();
	}

	/**
	 * Test del Constructor
	 */
	@Test
	public void testEventDAO() {
		eventDAO = (EventDAO) manager.getEventDAO();
		Assert.assertNotNull(eventDAO);
	}

	/**
	 * Test del metodo showAllEvents
	 */
	@Test
	public void testShowAllEvents() {
		List<Event> eventList = eventDAO.showAllEvents();
		if (eventList.size() > 0) {
			for (Event event : eventList) {

				System.out.println("ID: " + event.getEventId() + "Name: " + event.getName() + 
						"Descri :"+ event.getDescription() + "Place:" + event.getPlace() + 
						"Dura:" + event.getDuration() + "Type:"+ event.getEventType() + 
						"SeatAv:" + event.getSeatsAEvent());

			}
		}
		
		Assert.assertEquals("Evento 1",eventList.get(0).getName());
	}
	
	/**
	 * Test Exception showAllEvents
	 */
	@Test(expected = DAOException.class)
	public void exceptionShowAllEvents(){
		List<Event> eventList = eventDAO.showAllEvents();
		
	}

	/**
	 * Test del metodo showAllEvents(event)
	 */
	@Test
	public void testShowAllEventsEvent() {
		Event e = new Event();
		e.setName("Evento 1");
		List<Event> eventList = eventDAO.showAllEvents(e);
		if (eventList.size() > 0) {
			for (Event event : eventList) {

				System.out.println("ID: " + event.getEventId() + "Name: " + event.getName() + 
						"Descri :"+ event.getDescription() + "Place:" + event.getPlace() + 
						"Dura:" + event.getDuration() + "Type:"+ event.getEventType() + 
						"SeatAv:" + event.getSeatsAEvent());

			}
		}
		
		
	}
	
	/**
	 * Test Exception showAllEvents
	 */
	@Test(expected = DAOException.class)
	public void exceptionShowAllEventsEvent(){
		Event e = new Event();
		e.setName("Evento 1");
		List<Event> eventList = eventDAO.showAllEvents(e);
		
	}


	/**
	 * Test metodo getEvent
	 */
	@Test
	public void testGetEvent() {
		Event event = eventDAO.getEvent(2);
		
		System.out.println("ID: " + event.getEventId() + "Name: " + event.getName() + 
				"Descri :"+ event.getDescription() + "Place:" + event.getPlace() + 
				"Dura:" + event.getDuration() + "Type:"+ event.getEventType() + 
				"SeatAv:" + event.getSeatsAEvent());
		
	}

	/**
	 * Test metodo update event
	 */
	@Test
	public void testUpdateEvent() {
		Event evento = new Event();
		evento.setEventId(2);
		evento.setName("Evento 3");
		evento.setDescription("Evento 3");
		evento.setPlace("Place 3");
		evento.setDuration("1200-1400");
		evento.setEventType("Type 3");
		evento.setSeatsAEvent(100);
		
		eventDAO.updateEvent(evento);
		
	}

	/**
	 * test metodo insert event
	 */
	@Test
	public void testInsertEvent() {
		Event evento = new Event();
		evento.setEventId(4);
		evento.setName("Evento 40");
		evento.setDescription("Evento 40");
		evento.setPlace("Place 3");
		evento.setDuration("1500-1800");
		evento.setEventType("Type 40");
		evento.setSeatsAEvent(23);
		
		eventDAO.insertEvent(evento);
		
	}

	/**
	 * test metodo deleted event
	 */
	@Test
	public void testDeleteEvent() {
		eventDAO.deleteEvent(3);
	}

	/**
	 * 	Test del metodo updateSeatsEventDec
	 */
	@Test
	public void testUpdateSeatsEventDec() {
		Event e = new Event();
		e.setEventId(2);
		
		eventDAO.updateSeatsEventDec(e);
	}

	/**
	 * test UpdateSeatsEventInc
	 */
	@Test
	public void testUpdateSeatsEventInc() {
		Event e = new Event();
		e.setEventId(2);
		
		eventDAO.updateSeatsEventInc(e);
	}

}
