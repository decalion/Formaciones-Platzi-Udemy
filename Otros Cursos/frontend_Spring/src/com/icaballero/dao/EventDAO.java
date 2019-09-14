package com.icaballero.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.icaballero.entity.Event;
import com.icaballero.entity.Visitor;

@Component
public class EventDAO {

	private static Logger log = Logger.getLogger(EventDAO.class);


	public EventDAO() {

	}

	public List<Event> showAllEvents() throws NoResultException,
			PersistenceException {


		return null;
	}

	@Transactional
	public void updateEventNominations(int eventid) throws PersistenceException {

	}

	public boolean checkEventsofVisitor(Visitor visitor, int eventid)
			throws NonUniqueResultException, PersistenceException {


		return false;
	}

	@Transactional
	public void updateEventDeletions(int eventid) throws PersistenceException {

	}

}
