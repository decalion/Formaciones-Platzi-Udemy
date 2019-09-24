package com.icaballero;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletFormulario01
 */
@WebServlet("/ServletFormulario03")
public class ServletFormulario03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter();
		if(request.getParameter("java") != null) {
			pw.println("has pulsado sobre la opcion de "+request.getParameter("java"));
		}
		if(request.getParameter("net") != null) {
			pw.println("has pulsado sobre la opcion de "+request.getParameter("net"));
		}
		


	}

}
