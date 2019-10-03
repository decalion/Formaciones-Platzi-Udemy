package com.icaballero.servletcontext03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext001
 */
@WebServlet("/ServletContext001")
public class ServletContext001 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext contexto = getServletContext();
		
		contexto.setAttribute("nombre", "Ismael");
		
		PrintWriter pw = response.getWriter();
		
		pw.println("Variable guardada");
		
		pw.close();
		
	}


}
