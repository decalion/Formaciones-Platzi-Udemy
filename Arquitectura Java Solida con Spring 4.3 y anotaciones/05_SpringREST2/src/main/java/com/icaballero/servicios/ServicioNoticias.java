package com.icaballero.servicios;

import com.icaballero.bo.Comentario;
import com.icaballero.bo.Noticia;
import com.icaballero.repositorios.ComentarioRepositorio;
import com.icaballero.repositorios.NoticiaRepositorio;

public interface ServicioNoticias {

	Comentario findOneComentario(Integer k);

	Iterable<Comentario> findAllComentario();

	void saveComentario(Comentario tipo);

	void deleteComentario(Comentario tipo);

	Noticia findOneNoticia(String k);

	Iterable<Noticia> findAllNoticia();

	void saveNoticia(Noticia tipo);

	void deleteNoticia(Noticia tipo);
	
	
	 NoticiaRepositorio getRepositorioNoticias();
	 void setRepositorioNoticias(NoticiaRepositorio repositorioNoticias);
	 ComentarioRepositorio getRepositorioComentarios();
	 void setRepositorioComentarios(ComentarioRepositorio repositorioComentarios);
	
	 
	 public Iterable<Noticia> findAllNoticiasByOrderByTitulo();
	 public Iterable<Noticia> findAllNoticiasByOrderByAutor();
	 public Iterable<Noticia> findByNoticiasTituloLike(String titulo);

}