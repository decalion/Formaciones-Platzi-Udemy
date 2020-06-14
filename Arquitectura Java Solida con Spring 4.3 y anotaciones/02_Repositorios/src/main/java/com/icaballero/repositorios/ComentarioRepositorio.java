package com.icaballero.repositorios;

import com.icaballero.bo.Comentario;


public interface ComentarioRepositorio {
	
	public Comentario findOne(int numero);
	public Iterable<Comentario> findAll();
	public void save(Comentario comentario);
	public void delete(Comentario comentario);

}
