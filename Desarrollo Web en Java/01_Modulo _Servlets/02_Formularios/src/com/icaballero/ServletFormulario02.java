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
@WebServlet("/ServletFormulario02")
public class ServletFormulario02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter();
		int tope = Integer.parseInt(request.getParameter("numero"));
		for (int i = 0; i < tope; i++) {
			
			pw.println(" "+i);
		}
	}

}
