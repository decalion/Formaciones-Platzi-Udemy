package com.icaballero.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icaballero.interfaces.RequestHandler;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.services.EventService;

public class DeletedEventHandle implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EventService eService = new EventService();
		
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		
		
		return "admin.jsp";
	}

}
