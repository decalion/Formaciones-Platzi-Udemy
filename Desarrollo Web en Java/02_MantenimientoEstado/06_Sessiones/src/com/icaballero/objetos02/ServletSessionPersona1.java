package com.icaballero.objetos02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletSessionPersona1
 */
@WebServlet("/ServletSessionPersona1")
public class ServletSessionPersona1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession miSession = request.getSession(true);
		
		String nombre = request.getParameter("nombre");
		
		Persona p = new Persona(nombre);
		
		miSession.setAttribute("persona", p);
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>");
		pw.println("<body>");
		pw.println("Persona registrada " + p.getNombre());
		pw.println("<a href='FormularioCurso.html'>Formulario Curso</a>");
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	}

}
