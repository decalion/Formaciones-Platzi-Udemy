package com.icaballero.servicios.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icaballero.bo.Comentario;
import com.icaballero.bo.Noticia;
import com.icaballero.repositorios.ComentarioRepositorio;
import com.icaballero.repositorios.NoticiaRepositorio;
import com.icaballero.servicios.ServicioNoticias;

@Service
public class ServicioNoticiasJPA implements ServicioNoticias {
	
	@Autowired
	private NoticiaRepositorio repositorioNoticias;
	
	@Autowired
	private ComentarioRepositorio repositorioComentarios;
	
	
	
	
	public Comentario findOneComentario(Integer k) {
		return repositorioComentarios.findOne(k);
	}

	public Iterable<Comentario> findAllComentario() {
		return repositorioComentarios.findAll();
	}
	@Transactional
	public void saveComentario(Comentario tipo) {
		repositorioComentarios.save(tipo);
	}
	@Transactional
	public void deleteComentario(Comentario tipo) {
		repositorioComentarios.delete(tipo);
	}
	
	public Noticia findOneNoticia(String k) {
		return repositorioNoticias.findOne(k);
	}
	
	public Iterable<Noticia> findAllNoticia() {
		return repositorioNoticias.findAll();
	}
	@Transactional
	public void saveNoticia(Noticia tipo) {
		repositorioNoticias.save(tipo);
	}
	@Transactional
	public void deleteNoticia(Noticia tipo) {
		repositorioNoticias.delete(tipo);
	}
	public NoticiaRepositorio getRepositorioNoticias() {
		return repositorioNoticias;
	}
	public void setRepositorioNoticias(NoticiaRepositorio repositorioNoticias) {
		this.repositorioNoticias = repositorioNoticias;
	}
	public ComentarioRepositorio getRepositorioComentarios() {
		return repositorioComentarios;
	}
	public void setRepositorioComentarios(ComentarioRepositorio repositorioComentarios) {
		this.repositorioComentarios = repositorioComentarios;
	}
	
	
	
	
	

}
