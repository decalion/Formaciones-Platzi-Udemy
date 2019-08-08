package com.bolsadeideas.springboot.app.models.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {

	/**
	 * Ejemplo de consulta
	 * @param term
	 * @return
	 */
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String term);
	
	
	
	/**
	 * Ejemplo 2 de consulta
	 * @param term
	 * @return
	 */
	public List<Producto> findByNombreLikeIgnoreCase(String term);
}
