package com.icaballero.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icaballero.interfaces.RequestHandler;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.services.EventService;
import es.coritel.codington.festival.services.VisitorService;

public class UnregisterEventHandle implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<Event> listEvent;
		ArrayList<Event> registerList;
		HttpSession session = req.getSession();
		VisitorService vService = new VisitorService();
		EventService eService = new EventService();
		Visitor v = (Visitor) session.getAttribute("visitor");
		Event e = new Event();
		e.setEventId(Integer.parseInt(req.getParameter("eventId")));
		eService.unregisterEvent(v, e);
		
		
		listEvent = (ArrayList<Event>) eService.getAllEvents();
		registerList = (ArrayList<Event>) vService.showRegisteredEvents(v);
		session.setAttribute("listEvents", listEvent);
		session.setAttribute("registerEvent", registerList);
		
		
		return "principal.jsp";
	}

}
