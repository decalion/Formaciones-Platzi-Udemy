package com.icaballero.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.icaballero.bo.Noticia;

//@Repository
@RepositoryRestResource(path="noticias", collectionResourceRel = "noticias")
public interface NoticiaRepositorio extends JpaRepository<Noticia, String> {
	

	//Named methos de ordenacions
	public Iterable<Noticia> findAllByOrderByTitulo();
	public Iterable<Noticia> findAllByOrderByAutor();
	
	//Named Methods de busqueda
	public Iterable<Noticia> findByTituloLike(String titulo);
	

}
