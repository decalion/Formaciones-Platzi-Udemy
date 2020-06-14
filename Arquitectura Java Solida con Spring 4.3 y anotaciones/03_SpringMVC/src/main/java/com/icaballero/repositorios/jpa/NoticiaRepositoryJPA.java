package com.icaballero.repositorios.jpa;



import org.springframework.stereotype.Repository;

import com.icaballero.bo.Noticia;
import com.icaballero.repositorios.NoticiaRepositorio;

@Repository
public class NoticiaRepositoryJPA extends GenericRepositoryJPA<Noticia, String> implements NoticiaRepositorio{

	public NoticiaRepositoryJPA() {
		super(Noticia.class);
		
	}

	
}
