package com.icaballero.sessiones01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet001Session
 */
@WebServlet("/Servlet001Session")
public class Servlet001Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession misession = request.getSession(true);
		
		misession.setAttribute("curso", "Java Web");
		
		
		PrintWriter pw = response.getWriter();
		pw.println("Objeto almacenado en la session");
		pw.close();
	}


}
