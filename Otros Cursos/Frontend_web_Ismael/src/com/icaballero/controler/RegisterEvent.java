package com.icaballero.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icaballero.interfaces.RequestHandler;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.services.EventService;

public class RegisterEvent implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		EventService eService = new EventService();
		Event e = new Event();
		e.setName(req.getParameter("name"));
		e.setDescription(req.getParameter("desc"));
		e.setPlace(req.getParameter("place"));
		e.setDuration(req.getParameter("duration"));
		e.setEventType(req.getParameter("type"));
		e.setSeatsAEvent(Integer.parseInt(req.getParameter("seats")));
		
		
		eService.insertEvent(e);
		
		
		return "admin.jsp";
	}

}
