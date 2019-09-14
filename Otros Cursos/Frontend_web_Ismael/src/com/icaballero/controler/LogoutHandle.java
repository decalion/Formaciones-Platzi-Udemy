package com.icaballero.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icaballero.interfaces.RequestHandler;

public class LogoutHandle implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getSession().invalidate();
		
		
		return "index.jsp";
	}

}
