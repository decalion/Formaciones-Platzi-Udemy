package com.icaballero.app.modelo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.icaballero.app.modelo.Pais;

@RepositoryRestResource(exported = false)
public interface PaisRepositorio extends JpaRepository<Pais, Long>{

}
