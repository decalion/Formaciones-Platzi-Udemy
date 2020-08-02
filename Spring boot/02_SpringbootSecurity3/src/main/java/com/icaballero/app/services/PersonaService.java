package com.icaballero.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icaballero.app.domain.Persona;
import com.icaballero.app.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

//	static List<Persona> lista = new ArrayList<Persona>();
//	
//	static {
//		Persona p1 = new Persona("pepe", "perez", 30);
//		Persona p2 = new Persona("ana", "sanchez", 25);
//		lista.add(p1);
//		lista.add(p2);
//	}
//	

	public List<Persona> buscarTodos() {

		return personaRepository.buscarTodos();
	}

	public void borrar(Persona persona) {

		personaRepository.borrar(persona);
	}

	public void insertar(Persona persona) {

		personaRepository.insertar(persona);
	}

}
