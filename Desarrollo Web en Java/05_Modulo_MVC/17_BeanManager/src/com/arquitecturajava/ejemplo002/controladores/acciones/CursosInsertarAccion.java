package com.arquitecturajava.ejemplo002.controladores.acciones;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.ejemplo002.negocio.Curso;
import com.arquitecturajava.ejemplo002.servicios.ServicioCursos;
@Named
public class CursosInsertarAccion implements Accion {

	@Inject
	ServicioCursos sc;
	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Curso c = new Curso(request.getParameter("nombre"), Integer.parseInt(request.getParameter("nivel")));
		sc.insertar(c);
		response.sendRedirect("lista");
	}

}
