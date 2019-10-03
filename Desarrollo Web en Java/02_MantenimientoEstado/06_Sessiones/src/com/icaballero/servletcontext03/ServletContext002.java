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
 * Servlet implementation class ServletContext002
 */
@WebServlet("/ServletContext002")
public class ServletContext002 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto = getServletContext();
		
		PrintWriter pw = response.getWriter();
		
		pw.println(contexto.getAttribute("nombre"));
		
		pw.close();
		
	}


}
