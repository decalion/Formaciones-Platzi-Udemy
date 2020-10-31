package com.icaballero.holamundo.services.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icaballero.holamundo.entity.Persona;
import com.icaballero.holamundo.repositorios.IPersonaDao;
import com.icaballero.holamundo.services.IPersonaServices;

@Service
public class PersonaServicesImpl implements IPersonaServices {

	@Autowired
	private IPersonaDao personaRepository;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> listaPersona() {
		
		return (List<Persona>) personaRepository.findAll();
	}

	@Override
	@Transactional
	public void guardar(Persona persona) {
		personaRepository.save(persona);
		
	}

	@Override
	@Transactional
	public void eliminar(Persona persona) {
		personaRepository.delete(persona);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Persona encontrarPersona(Persona persona) {

		
		return personaRepository.findById(persona.getId_persona()).orElse(null);
	}

}
