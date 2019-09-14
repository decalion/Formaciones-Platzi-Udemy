package com.icaballero.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icaballero.interfaces.RequestHandler;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.services.EventService;

public class SearchHandle implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String eventName=req.getParameter("search");
		EventService eService = new EventService();
		ArrayList<Event> eventList = new ArrayList<>();
		Event e;
		
		if(eventName!=null && eventName.length()>1){
			e = new Event();
			e.setName(eventName);
			eventList = (ArrayList<Event>) eService.getAllEvents(e);
			req.getSession().setAttribute("listEvents", eventList);
		}
		
	
		return "principal.jsp";
	}

}
