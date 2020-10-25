package com.icaballero.holamundo.services;

import java.util.List;

import com.icaballero.holamundo.entity.Persona;

public interface IPersonaServices {
	
	public List<Persona> listaPersona();
	
	public void guardar(Persona persona);
	
	public void eliminar(Persona persona);
	
	public Persona encontrarPersona(Persona persona);
	

}
