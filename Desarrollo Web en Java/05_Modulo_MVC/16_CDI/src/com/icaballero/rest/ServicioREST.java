package com.icaballero.rest;



import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.icaballero.negocio.Curso;
import com.icaballero.servicios.ServicioCursos;

@ApplicationScoped
@Path(value = "/cursos")
public class ServicioREST {

	@Inject
	ServicioCursos sc;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> listaCursos() {
		
			ServicioCursos sc= new ServicioCursos();
			return sc.buscarTodos();
		
		
	}

	@GET
	@Path("/filtro/{nombre:.*}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> filtroPorNombre(@PathParam("nombre") String nombre) {
				
		
			//ServicioCursos sc= new ServicioCursos();
			return sc.buscarPorNombre(nombre);
		
	}
	
	
}
