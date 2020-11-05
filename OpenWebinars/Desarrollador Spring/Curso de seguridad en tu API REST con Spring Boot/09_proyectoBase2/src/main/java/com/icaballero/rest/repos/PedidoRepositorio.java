package com.icaballero.rest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icaballero.rest.modelo.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
	
	

}
