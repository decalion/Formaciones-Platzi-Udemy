package com.icaballero.rest.service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.icaballero.rest.dto.CreatePedidoDto;
import com.icaballero.rest.modelo.LineaPedido;
import com.icaballero.rest.modelo.Pedido;
import com.icaballero.rest.modelo.Producto;
import com.icaballero.rest.repos.PedidoRepositorio;
import com.icaballero.rest.service.base.BaseService;
import com.icaballero.rest.users.model.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServicio extends BaseService<Pedido, Long, PedidoRepositorio> {
	
	private final ProductoServicio productoServicio;
	
	public Pedido nuevoPedido(CreatePedidoDto nuevo, UserEntity cliente) {
		
		return save(Pedido.builder()
				.cliente(cliente)
				.lineas(nuevo.getLineas().stream()
							.map(lineaDto -> {
								
								Optional<Producto> p = productoServicio.findById(lineaDto.getProductoId());								
								if (p.isPresent()) {
									Producto producto = p.get();
									return LineaPedido.builder()
											.cantidad(lineaDto.getCantidad())
											.precio(producto.getPrecio())
											.producto(producto)
											.build();
								} else {
									return null;
								}
							})
							.filter(Objects::nonNull)
							.collect(Collectors.toSet())
						)							
				.build());
		
		
	}

}
