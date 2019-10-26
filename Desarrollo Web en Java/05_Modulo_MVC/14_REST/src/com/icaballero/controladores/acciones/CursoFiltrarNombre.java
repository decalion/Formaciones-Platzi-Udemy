package com.icaballero.controladores.acciones;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icaballero.servicios.ServiciosCurso;

public class CursoFiltrarNombre implements Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		ServiciosCurso sc = new ServiciosCurso();
		RequestDispatcher despachador = request.getRequestDispatcher("/listaCursos.jsp");
		request.setAttribute("listaCursos", sc.buscarPorNombre(request.getParameter("filtroNombre")));
		despachador.forward(request, response);
		
	}

}
