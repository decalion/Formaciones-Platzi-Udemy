package com.icaballero.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.icaballero.app.modelo.Lote;

public interface LoteRepositorio extends JpaRepository<Lote, Long>{
	
	@Query("select l from Lote l JOIN FETCH l.productos WHERE l.id = :id")
	public Optional<Lote> findByIdJoinFetch(Long id);

}
