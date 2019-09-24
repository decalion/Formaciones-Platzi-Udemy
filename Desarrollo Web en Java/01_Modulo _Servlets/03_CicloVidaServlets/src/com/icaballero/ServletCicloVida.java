package com.icaballero;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCicloVida
 */

/**
 * 
 * Los servlets a partir de la version 3-0 o superior se pueden definir por anotaciones.
 * los servlets anteriores a la 3.0 se tienen que definir en el web.xml
 * 
 * Ejemplo de ciclo de vida con web.xml
 * @author ismael
 *
 */
public class ServletCicloVida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private int peticiones;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		//con el ServletConfig obtenemos accesos a lo que hay en el fichero web.xml
		peticiones =Integer.parseInt(config.getInitParameter("inicio"));
		
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		pw.println(peticiones);
		peticiones++;
		pw.close();
	}


}
