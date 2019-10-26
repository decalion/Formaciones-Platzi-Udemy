package com.icaballero.controladores;

import java.io.IOException;

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

		procesarPeticion(request, response);
	}

	protected void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String accion = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		Accion miaccion=null;
		
		if (accion.equals("lista")) {

					miaccion= new ListaCursoAccion();
					miaccion.ejecutar(request, response);
			
		} else if (accion.equals("formularioInsertar")) {

				miaccion=new FormularioCursoAccion();
				miaccion.ejecutar(request, response);
		} else if (accion.equals("borrar")) {

				miaccion=new CursosBorrarAccion();
				miaccion.ejecutar(request, response);
		}else if (accion.equals("filtrar")) {

			miaccion=new  CursoFiltrarNombre();
			miaccion.ejecutar(request, response);
	}else {
			
			miaccion= new CursosInsertarAccion();
			miaccion.ejecutar(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

}


