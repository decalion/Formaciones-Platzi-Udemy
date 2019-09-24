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
@WebServlet("/ServletFormulario06")
public class ServletFormulario06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter();
		
		String[] lista = request.getParameterValues("curso");
		
		for (String v : lista) {
				pw.println(v);
			
		}


	}

}
