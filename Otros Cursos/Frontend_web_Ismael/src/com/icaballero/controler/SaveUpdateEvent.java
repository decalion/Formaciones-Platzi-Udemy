package com.icaballero.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icaballero.interfaces.RequestHandler;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.services.EventService;

public class SaveUpdateEvent implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		EventService eService = new EventService();

		Event e = (Event) session.getAttribute("event");
		e.setName(req.getParameter("name"));
		e.setDescription(req.getParameter("desc"));
		e.setPlace(req.getParameter("place"));
		e.setDuration(req.getParameter("duration"));
		e.setEventType(req.getParameter("eventype"));
		e.setSeatsAEvent(Integer.parseInt(req.getParameter("seats")));

		eService.updateEvent(e);

		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		session.setAttribute("listEvents", listEvent);

		return "admin.jsp";
	}

}
