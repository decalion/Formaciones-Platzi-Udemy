package com.icaballero.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.icaballero.negocio.Curso;
import com.icaballero.servicios.ServiciosCurso;

@Path(value = "/cursos")
public class ServicioRest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> listaCursos() {
		
			ServiciosCurso sc= new ServiciosCurso();
			return sc.buscarTodo();
		
		
	}

	@GET
	@Path("/filtro/{nombre:.*}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> filtroPorNombre(@PathParam("nombre") String nombre) {
		
			ServiciosCurso sc= new ServiciosCurso();
			return sc.buscarPorNombre(nombre);
		
		
	}
	

	
	
	
}
