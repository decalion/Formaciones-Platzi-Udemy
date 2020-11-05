package com.icaballero.rest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icaballero.rest.modelo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
