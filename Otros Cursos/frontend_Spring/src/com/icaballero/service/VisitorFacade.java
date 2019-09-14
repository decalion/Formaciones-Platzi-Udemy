package com.icaballero.service;


import java.util.List;

import com.icaballero.entity.Visitor;
import com.icaballero.exceptions.FERSGenericException;

public interface VisitorFacade {

	public boolean createVisitor(Visitor visitor);

	public Visitor searchVisitor(String username, String password);

	public void registerVisitor(Visitor visitor, int eventid);

	public List<Object[]> showRegisteredEvents(Visitor visitor);

	public int updateVisitorDetails(Visitor visitor);

	public int changePassword(Visitor visitor) throws FERSGenericException;

	public void unregisterEvent(Visitor visitor, int eventid);

	public boolean searchVisitor(String username);
}
