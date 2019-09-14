package com.icaballero.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icaballero.domain.Coche;
import com.icaballero.domain.Persona;

/**
 * Servlet implementation class GestionarDatosServlet
 */
@WebServlet("/enviarDatos")
public class GestionarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionarDatosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processHandle(request, response);
	}

	private void processHandle(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Coche c1 = new Coche("Hyunday","Santa Fe",2014);
		request.setAttribute("coche", c1);
		
		Coche c = new Coche("Chevrolet","Cruze",2015);
		Persona p = new Persona();
		p.setCoche(c);
		p.setNombre("Marcos");
		p.setApellido("García");
		p.setEdad(20);
		
		
        HttpSession session = request.getSession();
        session.setAttribute("persona", p);
         
        response.addCookie(new Cookie("Galleta","Valor de la galleta"));
        getServletContext().setAttribute("varApplication","Cargado en ambito Application");
         
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/principal.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processHandle(request, response);
	}

}
