package com.icaballero.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icaballero.negocio.Curso;
import com.icaballero.servicios.ServiciosCurso;

/**
 * Servlet implementation class ServletControlador
 */
@WebServlet("/ServletControlador/*")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarPeticion(request, response);
	}
	
	
	
	protected void processarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Centralizamos las peticiones en un unico lugar
		
		String accion = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		
		if(accion.equals("ServletControlador")) {
		
			ServiciosCurso sc = new ServiciosCurso();
			List<Curso> lista =sc.buscarTodo();
			RequestDispatcher despachador = request.getRequestDispatcher("/listaCursos.jsp");
			request.setAttribute("listaCursos", lista);
			despachador.forward(request, response);
		}else if(accion.equals("formularioInsertar")) {
			
			
			RequestDispatcher despachador = request.getRequestDispatcher("/formularioCurso.jsp");
			despachador.forward(request, response);
		} else if(accion.equals("borrar")) {
				
			ServiciosCurso sc = new ServiciosCurso();
			Curso c = new Curso(request.getParameter("nombre"), Integer.parseInt(request.getParameter("nivel")));
			sc.borrar(c);
			RequestDispatcher despachador = request.getRequestDispatcher("ServletControlador");
			despachador.forward(request, response);
			
		} else {
			
			ServiciosCurso sc = new ServiciosCurso();
			Curso c = new Curso(request.getParameter("nombre"), Integer.parseInt(request.getParameter("nivel")));
			sc.add(c);
			RequestDispatcher despachador = request.getRequestDispatcher("ServletControlador");
			despachador.forward(request, response);
		
		}
		
		
		
		
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processarPeticion(request, response);
		
	}

}
