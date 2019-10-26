package com.icaballero.controladores;

import java.io.IOException;


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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processarPeticion(request, response);
	}

	protected void processarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Centralizamos las peticiones en un unico lugar

		String accion = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		ServiciosCurso sc = new ServiciosCurso();
		RequestDispatcher despachador = null;

		if (accion.equals("ServletControlador")) {

			despachador = request.getRequestDispatcher("/listaCursos.jsp");
			request.setAttribute("listaCursos", sc.buscarTodo());

		} else if (accion.equals("formularioInsertar")) {

			despachador = request.getRequestDispatcher("/formularioCurso.jsp");

		} else if (accion.equals("borrar")) {

			Curso c = new Curso(request.getParameter("nombre"), Integer.parseInt(request.getParameter("nivel")));
			sc.borrar(c);
			despachador = request.getRequestDispatcher("ServletControlador");

		} else {

			Curso c = new Curso(request.getParameter("nombre"), Integer.parseInt(request.getParameter("nivel")));
			sc.add(c);
			despachador = request.getRequestDispatcher("ServletControlador");

		}

		despachador.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processarPeticion(request, response);

	}

}
