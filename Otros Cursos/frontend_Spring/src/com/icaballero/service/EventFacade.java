package com.icaballero.service;

import java.util.List;

import com.icaballero.entity.Event;
import com.icaballero.entity.Visitor;

public interface EventFacade {

	public List<Event> getAllEvents();

	public boolean checkEventsofVisitor(Visitor visitor, int eventid);

	public void updateEventDeletions(int eventid);


}
