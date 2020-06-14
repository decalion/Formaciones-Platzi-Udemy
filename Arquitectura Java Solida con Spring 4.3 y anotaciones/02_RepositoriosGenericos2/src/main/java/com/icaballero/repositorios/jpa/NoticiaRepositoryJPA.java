package com.icaballero.repositorios.jpa;



import com.icaballero.bo.Noticia;
import com.icaballero.repositorios.NoticiaRepositorio;

public class NoticiaRepositoryJPA extends GenericRepositoryJPA<Noticia, String> implements NoticiaRepositorio{

	public NoticiaRepositoryJPA() {
		super(Noticia.class);
		
	}

	
}
