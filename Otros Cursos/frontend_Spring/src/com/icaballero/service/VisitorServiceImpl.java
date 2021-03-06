package com.icaballero.service;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icaballero.dao.EventDAO;
import com.icaballero.dao.VisitorDAO;
import com.icaballero.entity.Visitor;
import com.icaballero.exceptions.FERSGenericException;

@Transactional
@Component
public class VisitorServiceImpl implements VisitorFacade {

	@Autowired
	private VisitorDAO visitorDAO;

	@Autowired
	private EventDAO eventDAO;


	public boolean createVisitor(Visitor visitor) {
		return visitorDAO.insertData(visitor);
	}

	public Visitor searchVisitor(String username, String password) throws NoResultException{
		return visitorDAO.searchUser(username, password);
	}

	public void registerVisitor(Visitor visitor, int eventid) {
		visitorDAO.registerVisitorToEvent(visitor, eventid);
		eventDAO.updateEventNominations(eventid);

	}

	public List<Object[]> showRegisteredEvents(Visitor visitor) {
		return visitorDAO.registeredEvents(visitor);
	}


	public int updateVisitorDetails(Visitor visitor) {
		return visitorDAO.updateVisitor(visitor);
	}

	public int changePassword(Visitor visitor) throws FERSGenericException {
		return visitorDAO.changePassword(visitor);
	}

	public void unregisterEvent(Visitor visitor, int eventid) {
		visitorDAO.unregisterEvent(visitor, eventid);


	}

	public boolean searchVisitor(String username) {
		return visitorDAO.searchVisitor(username);
	}

}
