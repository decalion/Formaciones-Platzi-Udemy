package com.icaballero.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icaballero.dao.EventDAO;
import com.icaballero.entity.Event;
import com.icaballero.entity.Visitor;

@Transactional
@Component
public class EventServiceImpl implements EventFacade {

	@Autowired
	private EventDAO eventDAO;

	public List<Event> getAllEvents() {
		return eventDAO.showAllEvents();
	}

	public boolean checkEventsofVisitor(Visitor visitor, int eventid) {
		return eventDAO.checkEventsofVisitor(visitor, eventid);
	}

	public void updateEventDeletions(int eventid) {
		eventDAO.updateEventDeletions(eventid);

	}

}
