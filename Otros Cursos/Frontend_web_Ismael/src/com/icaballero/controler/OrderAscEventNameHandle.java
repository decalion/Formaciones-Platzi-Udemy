package com.icaballero.controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icaballero.interfaces.RequestHandler;
import com.icaballero.util.ComparatorEventNameAsc;
import com.icaballero.util.CompatorEventNameDesc;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.services.EventService;

public class OrderAscEventNameHandle implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sesion = req.getSession();
		ArrayList<Event> listEvent = new ArrayList<>();
		EventService eService = new EventService();
		listEvent = (ArrayList<Event>) eService.getAllEvents();
		
		Collections.sort(listEvent, new ComparatorEventNameAsc());
		sesion.setAttribute("listEvents", listEvent);
		
		return "principal.jsp";
	}

}
