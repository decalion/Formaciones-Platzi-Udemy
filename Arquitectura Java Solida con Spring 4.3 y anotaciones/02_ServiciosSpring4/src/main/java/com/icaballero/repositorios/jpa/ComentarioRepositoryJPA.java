package com.icaballero.repositorios.jpa;



import org.springframework.stereotype.Repository;

import com.icaballero.bo.Comentario;
import com.icaballero.repositorios.ComentarioRepositorio;

@Repository
public class ComentarioRepositoryJPA extends GenericRepositoryJPA<Comentario, Integer> implements ComentarioRepositorio {

	public ComentarioRepositoryJPA() {
		super(Comentario.class);
		
	}

	
	

}
