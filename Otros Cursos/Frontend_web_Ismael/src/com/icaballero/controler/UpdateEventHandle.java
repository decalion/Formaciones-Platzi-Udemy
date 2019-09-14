package com.icaballero.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icaballero.interfaces.RequestHandler;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.services.EventService;

public class UpdateEventHandle implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		EventService eService = new EventService();
		Event e = eService.getEvent(Integer.parseInt(req.getParameter("eventId")));
		req.getSession().setAttribute("event", e);
		
		
		return "updateEvent.jsp";
	}

}
