package com.icaballero;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletLeeCookie
 */
@WebServlet("/ServletLeeCookie")
public class ServletLeeCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Cookie[] listaCookies = request.getCookies();
		
		PrintWriter pw = response.getWriter();
		
		for (Cookie c : listaCookies) {
			
			pw.println(c.getName() + " , " + c.getValue());
			
		}
		
		pw.close();
	}


}
