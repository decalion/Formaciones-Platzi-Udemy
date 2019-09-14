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

public class LoginHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String handle = null;
		VisitorService vService;
		Visitor v;
		Visitor login;
		EventService eService;
		ArrayList<Event> listEvent;
		ArrayList<Event> registerList;
		HttpSession session;

		if (req.getParameter("username").length() >= 6) {
			vService = new VisitorService();
			v = new Visitor();
			v.setUserName(req.getParameter("username"));
			login = vService.searchVisitor(v);

			if (login.getPassword().equals(req.getParameter("password"))) {
                session = req.getSession();
				
				eService = new EventService();
				listEvent = (ArrayList<Event>) eService.getAllEvents();
				registerList = (ArrayList<Event>) vService.showRegisteredEvents(login);
				session.setAttribute("visitor", login);
				session.setAttribute("listEvents", listEvent);
				session.setAttribute("registerEvent", registerList);
				
				if(login.isAdmin()){
					handle = "admin.jsp";
				}else{
					handle = "principal.jsp";
				}
			} else {
				req.setAttribute("error", "Error en el usuario o la contraseña");
				handle = "index.jsp";

			}
		} else {

			req.setAttribute("error", "El usuario tiene que tener al menos 6 Caracteres");
			handle = "index.jsp";
		}

		return handle;
	}

}
