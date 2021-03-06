package com.icaballero.interfaces.daos;

import java.util.List;

import com.icaballero.domain.Event;
import com.icaballero.domain.EventSignUp;
import com.icaballero.exceptions.DAOException;

public interface IEventSignUpDAO {
	
	/**
	 * DAO for checking visitor has already registered for EVENT or
	 * not. Sends boolean values about status.
	 * @param visitor
	 * @param event
	 * @return
	 * @throws DAOException
	 *             
	 */
	public boolean checkEventsofVisitor(EventSignUp eventSignUp) throws DAOException;
	
	/**
	 *  DAO method to unregister visitor for particular events
	 * @param visitor
	 * @param event
	 * @throws ClassNotFoundException
	 * @throws DAOexception
	 *
	 */
	public void unregisterVisitorToEvent(EventSignUp eventSignUp)
			throws DAOException ;
	
	/**
	 * DAO method to register visitor to specific event and checking about status
	 * of visitor to particular event.
	 * @param visitor
	 * @param eventid
	 * @throws DAOException
	 *
	 */
	public void registerVisitorToEvent(EventSignUp eventSignUp)
			throws DAOException ;
	
	/**
	 * This method deletes the event on basis of eventid from database
	 * @param eventId
	 * @return
	 * @throws DAOException
	 */
	int deleteEventSignUp(int eventId) throws DAOException;
	
	/**
	 * DAO method to display all the events registered by particular visitor
	 * 
	 * @param visitor
	 * @return
	 * @throws DAOException
	 */
	public List<Event> registeredEvents(EventSignUp eventSignUp)
			throws DAOException;

}
