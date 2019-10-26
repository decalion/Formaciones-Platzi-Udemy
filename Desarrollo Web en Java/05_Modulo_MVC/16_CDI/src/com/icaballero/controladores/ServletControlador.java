package com.icaballero.controladores;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icaballero.controladores.acciones.Accion;
import com.icaballero.controladores.acciones.CursoFiltrarNombre;
import com.icaballero.controladores.acciones.CursosBorrarAccion;
import com.icaballero.controladores.acciones.CursosInsertarAccion;
import com.icaballero.controladores.acciones.FormularioCursoAccion;
import com.icaballero.controladores.acciones.ListaCursosAccion;
import com.icaballero.negocio.Curso;
import com.icaballero.servicios.ServicioCursos;

/**
 * Servlet implementation class ServletControlador
 */
@WebServlet("/ServletControlador/*")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//extraño
	@Inject
	ListaCursosAccion listaCursosAccion;
	@Inject
	FormularioCursoAccion formularioCursoAccion;
	@Inject
	CursosInsertarAccion cursosInsertarAccion;
	@Inject
	CursosBorrarAccion cursosBorrarAccion;
	@Inject
	CursoFiltrarNombre cursosFiltrarNombre;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		procesarPeticion(request, response);
	}

	protected void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String accion = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		
	
		
		if (accion.equals("lista")) {

					listaCursosAccion.ejecutar(request, response);
			
		} else if (accion.equals("formularioInsertar")) {

				formularioCursoAccion.ejecutar(request, response);
		} else if (accion.equals("borrar")) {

				cursosBorrarAccion.ejecutar(request, response);
		}else if (accion.equals("filtrar")) {

			cursosFiltrarNombre.ejecutar(request, response);
	}else {
			
			cursosInsertarAccion.ejecutar(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

}
