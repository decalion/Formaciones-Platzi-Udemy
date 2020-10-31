package com.icaballero.holamundo.repositorios;


import org.springframework.data.repository.CrudRepository;

import com.icaballero.holamundo.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long> {

	
	
}
