package com.icaballero.app.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.icaballero.app.domain.Persona;
import com.icaballero.app.mapper.PersonaMapper;

@Repository
public class PersonaRepository {
	
	@Autowired
	private JdbcTemplate plantilla;
	
	Logger logger = LoggerFactory.getLogger(PersonaRepository.class);
	
	
	public List<Persona> buscarTodos() {
		return plantilla.query("select * from Persona",new PersonaMapper());
		
		
	}
	
	public void borrar(Persona persona) {
		
		plantilla.update("delete from Persona where nombre=?",persona.getNombre());
	}
	
	public void insertar(Persona persona) {
		
		logger.info(persona.toString());
		
		plantilla.update("insert into Persona (nombre,apellidos,edad) values(?,?,?)",persona.getNombre(),persona.getApellidos(),persona.getEdad());
	}

}
