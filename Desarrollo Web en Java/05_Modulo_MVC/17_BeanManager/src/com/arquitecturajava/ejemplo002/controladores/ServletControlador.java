package com.arquitecturajava.ejemplo002.controladores;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.ejemplo002.controladores.acciones.Accion;
import com.arquitecturajava.ejemplo002.controladores.acciones.CursoFiltrarNombre;
import com.arquitecturajava.ejemplo002.controladores.acciones.CursosBorrarAccion;
import com.arquitecturajava.ejemplo002.controladores.acciones.CursosInsertarAccion;
import com.arquitecturajava.ejemplo002.controladores.acciones.FormularioCursoAccion;
import com.arquitecturajava.ejemplo002.controladores.acciones.ListaCursosAccion;
import com.arquitecturajava.ejemplo002.negocio.Curso;
import com.arquitecturajava.ejemplo002.servicios.ServicioCursos;

/**
 * Servlet implementation class ServletControlador
 */
@WebServlet("/ServletControlador/*")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	BeanManager beanManager;
	Accion tipoAccion;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		procesarPeticion(request, response);
	}

	protected void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		Set<Bean<?>> beans;
		System.out.println("pasa");

		if (accion.equals("lista")) {

			beans = beanManager.getBeans(ListaCursosAccion.class);
			Bean<ListaCursosAccion> bean = (Bean<ListaCursosAccion>) beanManager.resolve(beans);
			tipoAccion = beanManager.getContext(bean.getScope()).get(bean, beanManager.createCreationalContext(bean));
			

		} else if (accion.equals("formularioInsertar")) {

			beans = beanManager.getBeans(FormularioCursoAccion.class);
			Bean<FormularioCursoAccion> bean = (Bean<FormularioCursoAccion>) beanManager.resolve(beans);
			tipoAccion = beanManager.getContext(bean.getScope()).get(bean, beanManager.createCreationalContext(bean));

		} else if (accion.equals("borrar")) {
			beans = beanManager.getBeans(CursosBorrarAccion.class);
			Bean<CursosBorrarAccion> bean = (Bean<CursosBorrarAccion>) beanManager.resolve(beans);
		    tipoAccion = beanManager.getContext(bean.getScope()).get(bean, beanManager.createCreationalContext(bean));

		} else if (accion.equals("filtrar")) {

			beans = beanManager.getBeans(CursoFiltrarNombre.class);
			Bean<CursoFiltrarNombre> bean = (Bean<CursoFiltrarNombre>) beanManager.resolve(beans);
			tipoAccion = beanManager.getContext(bean.getScope()).get(bean, beanManager.createCreationalContext(bean));

			// cursosFiltrarNombre.ejecutar(request, response);
		} else {

			beans = beanManager.getBeans(CursosInsertarAccion.class);
			Bean<CursosInsertarAccion> bean = (Bean<CursosInsertarAccion>) beanManager.resolve(beans);
			tipoAccion = beanManager.getContext(bean.getScope()).get(bean, beanManager.createCreationalContext(bean));

			
		}
	
		tipoAccion.ejecutar(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

}
