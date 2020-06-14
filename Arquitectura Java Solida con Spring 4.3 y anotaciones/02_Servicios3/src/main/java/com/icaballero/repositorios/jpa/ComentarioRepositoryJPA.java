package com.icaballero.repositorios.jpa;



import com.icaballero.bo.Comentario;
import com.icaballero.repositorios.ComentarioRepositorio;

public class ComentarioRepositoryJPA extends GenericRepositoryJPA<Comentario, Integer> implements ComentarioRepositorio {

	public ComentarioRepositoryJPA() {
		super(Comentario.class);
		
	}

	
	

}
