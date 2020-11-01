package com.icaballero.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icaballero.app.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
