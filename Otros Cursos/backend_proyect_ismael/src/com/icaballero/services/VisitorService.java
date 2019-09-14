package com.icaballero.services;

import java.util.ArrayList;
import java.util.List;

import com.icaballero.daos.DAOManager;
import com.icaballero.daos.EventSignUpDAO;
import com.icaballero.daos.SequencerDAO;
import com.icaballero.daos.VisitorDAO;
import com.icaballero.domain.Event;
import com.icaballero.domain.EventSignUp;
import com.icaballero.domain.Visitor;
import com.icaballero.exceptions.DAOException;
import com.icaballero.exceptions.ServiceException;
import com.icaballero.interfaces.services.IVisitorService;

/**
 * 
 * @author Ismael Caballero
 *
 */
public class VisitorService implements IVisitorService {

	/**
	 * Constructor
	 */
	public VisitorService() {

	}

	/**
	 * Metodo que crea un Visitior
	 * @param Visitor
	 * @return true o false
	 */
	@Override
	public boolean createVisitor(Visitor visitor) throws ServiceException {
		DAOManager manager = null;
		boolean status = false;

		try {
			manager = new DAOManager();
			VisitorDAO visitorDAO = (VisitorDAO) manager.getVisitorDAO();
			SequencerDAO sequencerDAO = (SequencerDAO) manager.getSequencerDAO();
			if (!visitor.equals(visitorDAO.searchUser(visitor))) {

				visitor.setVisitorId(sequencerDAO.getNext("visitor"));
				visitorDAO.insertData(visitor);
				manager.closeOK();
				status = true;

			}

		} catch (Exception e) {
			manager.closeError();
			status = false;
			throw new ServiceException("Error VisitorServices createVisitor");

		}

		return status;
	}

	/**
	 * Metodo que busca un Visitor
	 * @param Visitor
	 * @return Visitor
	 */
	@Override
	public Visitor searchVisitor(Visitor visitor) throws ServiceException {
		DAOManager manager = null;
		Visitor v = null;

		try {

			manager = new DAOManager();
			VisitorDAO visitorDAO = (VisitorDAO) manager.getVisitorDAO();
			v = visitorDAO.searchUser(visitor);
			manager.closeOK();

		} catch (DAOException e) {
			manager.closeError();
			throw new ServiceException("Error VisitorServices searchVisitor");

		}

		return v;
	}

	/**
	 * Metod que devuelve la lista de los eventos que un visitor esta registrado
	 * @param Visitor
	 * @return List<Event>
	 */
	@Override
	public List<Event> showRegisteredEvents(Visitor visitor) throws ServiceException {
		DAOManager manager = null;

		List<Event> eventList = new ArrayList<Event>();
		EventSignUp eventSingUp = new EventSignUp();

		try {
			manager = new DAOManager();
			EventSignUpDAO eventSingUpDAO = (EventSignUpDAO) manager.getEventSingUpDAO();
			eventSingUp.setIdVisitor(visitor.getVisitorId());
			eventList = eventSingUpDAO.registeredEvents(eventSingUp);
			manager.closeOK();

		} catch (DAOException e) {
			manager.closeError();
			throw new ServiceException("Error VisitorServices showRegisteredEvents");

		}
		return eventList;
	}

	/**
	 * Metodo que Actualiza los detalles de un Visitor
	 * @param Visitor
	 * @return 1 si es correcto y -1 si no lo es
	 */
	@Override
	public int updateVisitorDetails(Visitor visitor) throws ServiceException {
		DAOManager manager = null;
		int status = -1;

		try {
			 manager = new DAOManager();
			VisitorDAO visitorDAO = (VisitorDAO) manager.getVisitorDAO();
			status = visitorDAO.updateVisitor(visitor);
			manager.closeOK();

		} catch (DAOException e) {
			manager.closeError();
			throw new ServiceException("Error VisitorServices updateVisitorDetails");

		}
		return status;
	}

	/**
	 * Metodo que cambia la password de un Visitor
	 * @param Visitor
	 * @return 1 si es correcto -1 si no lo es
	 */
	@Override
	public int changePassword(Visitor visitor) throws ServiceException {
		DAOManager manager = null;
		int status = -1;

		try {
			manager = new DAOManager();
			VisitorDAO visitorDAO = (VisitorDAO) manager.getVisitorDAO();
			status = visitorDAO.changePassword(visitor);
			manager.closeOK();

		} catch (DAOException e) {
			manager.closeError();
			throw new ServiceException("Error VisitorServices changePassword");

		}
		return status;
	}

}
