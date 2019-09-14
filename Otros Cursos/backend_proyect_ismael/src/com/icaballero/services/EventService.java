package com.icaballero.services;

import java.util.ArrayList;
import java.util.List;

import com.icaballero.daos.DAOManager;
import com.icaballero.daos.EventDAO;
import com.icaballero.daos.EventSignUpDAO;
import com.icaballero.daos.SequencerDAO;
import com.icaballero.domain.Event;
import com.icaballero.domain.EventSignUp;
import com.icaballero.domain.Visitor;
import com.icaballero.exceptions.DAOException;
import com.icaballero.exceptions.ServiceException;
import com.icaballero.interfaces.services.IEventService;

/**
 * 
 * @author Ismael Caballero
 *
 */
public class EventService implements IEventService {

	/**
	 * Constructor
	 */
	public EventService() {

	}

	/**
	 * Metodo que devuelve una lista con todos los eventos
	 * @return List<Event>
	 */
	@Override
	public List<Event> getAllEvents() throws ServiceException {
		DAOManager manager = null;
		

		List<Event> listEvent = new ArrayList<Event>();

		try {
			manager = new DAOManager();
			EventDAO eventDAO = (EventDAO) manager.getEventDAO();
			listEvent = eventDAO.showAllEvents();
			manager.closeOK();

		} catch (DAOException e) {
			manager.closeError();
			throw new ServiceException("Error EventServices getAllEvents");

		}

		return listEvent;
	}

	/**
	 * Metodo que devuelve todos los eventos del mismo nombre
	 * @param Event 
	 * @return List<Event>
	 * 	 
	 **/
	@Override
	public List<Event> getAllEvents(Event eventName) throws ServiceException {
		DAOManager manager = null;
		
		List<Event> listEvent = new ArrayList<Event>();

		try {

			manager = new DAOManager();
			EventDAO eventDAO = (EventDAO) manager.getEventDAO();
			listEvent = eventDAO.showAllEvents(eventName);
			manager.closeOK();

		} catch (DAOException e) {
			manager.closeError();
			throw new ServiceException("Error EventServices getAllEvents(name)");

		}

		return listEvent;
	}

	/**
	 * Metodo que devuelve un Event
	 * @param eventID
	 * @return Event
	 */
	@Override
	public Event getEvent(int eventId) throws ServiceException {
		DAOManager manager = null;
		
		Event event = new Event();

		try {
			manager = new DAOManager();
			EventDAO eventDAO = (EventDAO) manager.getEventDAO();
			manager = new DAOManager();
			event = eventDAO.getEvent(eventId);
			manager.closeOK();

		} catch (DAOException e) {
			manager.closeError();
			throw new ServiceException("Error EventServices getEvent");

		}

		return event;
	}

	/**
	 * Metodo para Modificar los datos de un evento
	 * @param Event
	 * @return 1 si es correcto -1 si es incorrecto
	 * 
	 */
	@Override
	public int updateEvent(Event event) throws ServiceException {
		DAOManager manager = null ;


		int status = -1;

		try {
			manager = new DAOManager();
			EventDAO eventDAO = (EventDAO) manager.getEventDAO();
			status = eventDAO.updateEvent(event);
			manager.closeOK();

		} catch (DAOException e) {
			manager.closeError();
			throw new ServiceException("Error EventServices updateEvent");

		}

		return status;
	}

	/**
	 * Metodo que borra un evento
	 * @param eventID
	 * @return 1 si es correcto -1 si es incorrecto
	 */
	@Override
	public int deleteEvent(int eventId) throws ServiceException {
		DAOManager manager = null ;

		int status = -1;

		try {
			manager = new DAOManager();
			EventDAO eventDAO = (EventDAO) manager.getEventDAO();
			EventSignUpDAO eventSingUpDAO = (EventSignUpDAO) manager.getEventSingUpDAO();
			eventSingUpDAO.deleteEventSignUp(eventId);
			status = eventDAO.deleteEvent(eventId);
			manager.closeOK();

		} catch (DAOException e) {
			manager.closeError();
			throw new ServiceException("Error EventServices deleteEvent");

		}

		return status;
	}

	/**
	 * Metodo que inserta un Evnet
	 * @param Event
	 * @return 1 si es correcto -1 si es incorrecto
	 */
	@Override
	public int insertEvent(Event event) throws ServiceException {
		DAOManager manager = null;

		int status = -1;

		try {
			manager = new DAOManager();
			EventDAO eventDAO = (EventDAO) manager.getEventDAO();
			SequencerDAO sequencerDAO = (SequencerDAO) manager.getSequencerDAO();
			event.setEventId(sequencerDAO.getNext("event"));
			status = eventDAO.insertEvent(event);
			manager.closeOK();

		} catch (DAOException e) {
			manager.closeError();
			throw new ServiceException("Error EventServices insertEvent");

		}

		return status;
	}

	/**
	 * Metodo que elimina un visitor de un evento
	 */
	@Override
	public void unregisterEvent(Visitor visitor, Event event) throws ServiceException {
		DAOManager manager = null;


		try {
			manager = new DAOManager();
			EventDAO eventDAO = (EventDAO) manager.getEventDAO();
			EventSignUpDAO eventSingUpDAO = (EventSignUpDAO) manager.getEventSingUpDAO();
			EventSignUp eventSignUp = new EventSignUp();

			eventSignUp.setIdEvent(event.getEventId());
			eventSignUp.setIdVisitor(visitor.getVisitorId());
			eventSingUpDAO.unregisterVisitorToEvent(eventSignUp);
			eventDAO.updateSeatsEventInc(event);
			manager.closeOK();

		} catch (DAOException e) {
			manager.closeError();
			throw new ServiceException("Error EventServices unregisterEvent");

		}

	}

	/**
	 * Metodo que registra un visitor a un evento
	 */
	@Override
	public void registerEvent(Visitor visitor, Event event) throws ServiceException {

		DAOManager manager = null;

		
		try {
			manager = new DAOManager();
			EventDAO eventDAO = (EventDAO) manager.getEventDAO();
			SequencerDAO sequencerDAO = (SequencerDAO) manager.getSequencerDAO();
			EventSignUpDAO eventSingUpDAO = (EventSignUpDAO) manager.getEventSingUpDAO();
			EventSignUp eventSignUp = new EventSignUp();
			eventSignUp.setIdEvent(event.getEventId());
			eventSignUp.setIdVisitor(visitor.getVisitorId());
			
			if (!eventSingUpDAO.checkEventsofVisitor(eventSignUp)) {
				eventSignUp.setId(sequencerDAO.getNext("event_signup"));
				eventSingUpDAO.registerVisitorToEvent(eventSignUp);
				eventDAO.updateSeatsEventDec(event);
				manager.closeOK();
			}

		} catch (DAOException e) {
			manager.closeError();
			throw new ServiceException("Error EventServices registerEvent");

		}

	}

}
