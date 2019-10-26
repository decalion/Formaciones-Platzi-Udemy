package com.icaballero.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icaballero.controladores.acciones.Accion;
import com.icaballero.controladores.acciones.CursosBorrarAccion;
import com.icaballero.controladores.acciones.CursosInsertarAccion;
import com.icaballero.controladores.acciones.FormularioCursoAccion;
import com.icaballero.controladores.acciones.ListaCursoAccion;
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

		Accion miAccion = null;

		if (accion.equals("lista")) {
			miAccion = new ListaCursoAccion();
			miAccion.ejecutar(request, response);

		} else if (accion.equals("formularioInsertar")) {

			miAccion = new FormularioCursoAccion();
			miAccion.ejecutar(request, response);
			

		} else if (accion.equals("borrar")) {

			miAccion = new CursosBorrarAccion();
			miAccion.ejecutar(request, response);

		} else {

			miAccion = new CursosInsertarAccion();
			miAccion.ejecutar(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processarPeticion(request, response);

	}

}
