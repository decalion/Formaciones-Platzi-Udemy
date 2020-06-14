package com.icaballero.servicios;

import com.icaballero.bo.Comentario;
import com.icaballero.bo.Noticia;

public interface ServicioNoticias {

	Comentario findOneComentario(Integer k);

	Iterable<Comentario> findAllComentario();

	void saveComentario(Comentario tipo);

	void deleteComentario(Comentario tipo);

	Noticia findOneNoticia(String k);

	Iterable<Noticia> findAllNoticia();

	void saveNoticia(Noticia tipo);

	void deleteNoticia(Noticia tipo);

}