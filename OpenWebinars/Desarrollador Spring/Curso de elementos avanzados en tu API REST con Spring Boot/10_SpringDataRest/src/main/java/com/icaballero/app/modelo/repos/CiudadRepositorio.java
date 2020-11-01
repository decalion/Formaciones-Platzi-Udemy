package com.icaballero.app.modelo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.icaballero.app.modelo.Ciudad;

@RepositoryRestResource(path = "ciudades", collectionResourceRel = "ciudades")
public interface CiudadRepositorio extends JpaRepository<Ciudad, Long>{

}
