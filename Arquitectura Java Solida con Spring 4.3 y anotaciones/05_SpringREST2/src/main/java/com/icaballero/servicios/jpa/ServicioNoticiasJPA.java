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
	
	
	
	@Override
	public Comentario findOneComentario(Integer k) {
		return repositorioComentarios.findOne(k);
	}

	@Override
	public Iterable<Comentario> findAllComentario() {
		return repositorioComentarios.findAll();
	}
	@Transactional
	@Override
	public void saveComentario(Comentario tipo) {
		repositorioComentarios.save(tipo);
	}
	@Transactional
	@Override
	public void deleteComentario(Comentario tipo) {
		repositorioComentarios.delete(tipo);
	}
	@Override
	public Noticia findOneNoticia(String k) {
		return repositorioNoticias.findOne(k);
	}
	@Override
	public Iterable<Noticia> findAllNoticia() {
		return repositorioNoticias.findAll();
	}
	@Transactional
	@Override
	public void saveNoticia(Noticia tipo) {
		repositorioNoticias.save(tipo);
	}
	@Transactional
	@Override
	public void deleteNoticia(Noticia tipo) {
		repositorioNoticias.delete(tipo);
	}
	@Override
	public NoticiaRepositorio getRepositorioNoticias() {
		return repositorioNoticias;
	}
	@Override
	public void setRepositorioNoticias(NoticiaRepositorio repositorioNoticias) {
		this.repositorioNoticias = repositorioNoticias;
	}
	@Override
	public ComentarioRepositorio getRepositorioComentarios() {
		return repositorioComentarios;
	}
	@Override
	public void setRepositorioComentarios(ComentarioRepositorio repositorioComentarios) {
		this.repositorioComentarios = repositorioComentarios;
	}

	@Override
	public Iterable<Noticia> findAllNoticiasByOrderByTitulo() {
		// TODO Auto-generated method stub
		return repositorioNoticias.findAllByOrderByTitulo();
	}

	@Override
	public Iterable<Noticia> findAllNoticiasByOrderByAutor() {
		// TODO Auto-generated method stub
		return repositorioNoticias.findAllByOrderByAutor();
	}

	@Override
	public Iterable<Noticia> findByNoticiasTituloLike(String titulo) {
		// TODO Auto-generated method stub
		return repositorioNoticias.findByTituloLike(titulo);
	}
	
	
	
	
	

}
