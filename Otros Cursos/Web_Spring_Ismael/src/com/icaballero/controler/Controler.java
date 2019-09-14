package com.icaballero.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.services.EventServiceImpl;
import es.coritel.codington.festival.services.VisitorServiceImpl;


@Controller
public class Controler {

	@Autowired
	private EventServiceImpl eService;

	@Autowired
	private VisitorServiceImpl vService;
	

	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		String handle = null;
		Visitor v ;
		Visitor login;
		ArrayList<Event> listEvent;
		ArrayList<Event> registerList;
		HttpSession session;

		if (req.getParameter("username").length() >= 6) {
			v = new Visitor();
			v.setUserName(req.getParameter("username"));
			login = vService.searchVisitor(v);

			if (login.getPassword().equals(req.getParameter("password"))) {
				session = req.getSession();
				listEvent = (ArrayList<Event>) eService.getAllEvents();
				registerList = (ArrayList<Event>) vService.showRegisteredEvents(login);
				session.setAttribute("visitor", login);
				session.setAttribute("listEvents", listEvent);
				session.setAttribute("registerEvent", registerList);

				if (login.isAdmin()) {
					handle = "admin";
				} else {
					handle = "principal";
				}
			} else {
				req.setAttribute("error", "Error en el usuario o la contraseña");
				handle = "index";

			}
		} else {

			req.setAttribute("error", "El usuario tiene que tener al menos 6 Caracteres");
			handle = "index";
		}

		// mv.addObject("eventos", eventlist);

		mv.setViewName(handle);

		return mv;

	}
/*
	@RequestMapping("DeletedEvent.do")
	public ModelAndView deleteEvent(HttpServletRequest req, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		eService = new EventService();
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		mv.setViewName("admin");

		return mv;
	}
	
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		eService = new EventService();
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		mv.setViewName("admin");

		return mv;
	}
	
	
	@RequestMapping("EventNameAsc.do")
	public ModelAndView orderAscEvent(HttpServletRequest req, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		eService = new EventService();
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		mv.setViewName("admin");

		return mv;
	}
	
	
	@RequestMapping("EventNameDesc.do")
	public ModelAndView orderDescEvent(HttpServletRequest req, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		eService = new EventService();
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		mv.setViewName("admin");

		return mv;
	}
	
	@RequestMapping("registerEvent.do")
	public ModelAndView registerEvent(HttpServletRequest req, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		eService = new EventService();
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		mv.setViewName("admin");

		return mv;
	}
	
	@RequestMapping("registerEventV.do")
	public ModelAndView registerEventHandler(HttpServletRequest req, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		eService = new EventService();
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		mv.setViewName("admin");

		return mv;
	}
	
	@RequestMapping("register.do")
	public ModelAndView register(HttpServletRequest req, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		eService = new EventService();
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		mv.setViewName("admin");

		return mv;
	}
	
	@RequestMapping("saveUpdateEvent.do")
	public ModelAndView saveUpdate(HttpServletRequest req, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		eService = new EventService();
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		mv.setViewName("admin");

		return mv;
	}
	
	@RequestMapping("search.do")
	public ModelAndView search(HttpServletRequest req, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		eService = new EventService();
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		mv.setViewName("admin");

		return mv;
	}

	
	@RequestMapping("unregisterEvent.do")
	public ModelAndView unRegisterEvent(HttpServletRequest req, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		eService = new EventService();
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		mv.setViewName("admin");

		return mv;
	}
	
	@RequestMapping("UpdateFormEvent.do")
	public ModelAndView updateEvent(HttpServletRequest req, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		eService = new EventService();
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		mv.setViewName("admin");

		return mv;
	}
	
	@RequestMapping("update.do")
	public ModelAndView update(HttpServletRequest req, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		eService = new EventService();
		eService.deleteEvent(Integer.parseInt(req.getParameter("eventId")));
		ArrayList<Event> listEvent = (ArrayList<Event>) eService.getAllEvents();
		req.getSession().setAttribute("listEvents", listEvent);
		mv.setViewName("admin");

		return mv;
	}
	*/
}
