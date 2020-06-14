package com.icaballero.repositorios;

import com.icaballero.bo.Noticia;

public interface NoticiaRepositorio {
	
	public Noticia findOne(String tipo);
	public Iterable<Noticia> findAll();
	public void save(Noticia noticia);
	public void delete(Noticia noticia);

}
