package com.icaballero.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icaballero.app.modelo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
