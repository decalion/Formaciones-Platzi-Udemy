package com.icaballero.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icaballero.bo.Comentario;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, Integer> {
	
	

}
