package com.icaballero.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icaballero.interfaces.RequestHandler;

import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.services.VisitorService;

public class RegisterHandle implements RequestHandler {

	/**
	 * 
	 */
	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String handle = null;
		String error = "Password don't match";
		VisitorService vService;

		if (req.getParameter("password").equals(req.getParameter("cpassword"))) {
			
			Visitor v = new Visitor();
			v.setFirstName(req.getParameter("firstName"));
			v.setLastName(req.getParameter("lastName"));
			v.setUserName(req.getParameter("userName"));
			v.setPassword(req.getParameter("password"));
			v.setDni("45858750Q");
			v.setEmail(req.getParameter("email"));
			v.setPhoneNumber(req.getParameter("phone"));
			v.setAddres(req.getParameter("addres"));

			vService = new VisitorService();

			vService.createVisitor(v);
			handle = "index.jsp";

		} else {
			req.setAttribute("error", error);
			handle = "register.jsp";
		}

		return handle;
	}

}
