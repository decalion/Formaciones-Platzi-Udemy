package com.icaballero.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icaballero.app.modelo.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}
