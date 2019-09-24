package com.icaballero;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCicloVida02
 */

/**
 * Ejemplo de ciclo de vida con anotaciones
 * las anotaciones se pueden usar a partir de la version 3.0 de servlets
 * @author ismael
 *
 */
@WebServlet(
		urlPatterns = { "/ServletCicloVida02" }, 
		initParams = { 
				@WebInitParam(name = "numero", value = "5", description = "numero de inicio")
		})
public class ServletCicloVida02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int peticiones;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		peticiones =Integer.parseInt(config.getInitParameter("numero"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println(peticiones);
		peticiones++;
		pw.close();
	}


}
