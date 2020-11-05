package com.icaballero.rest.dto.converter;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.icaballero.rest.dto.GetPedidoDto;
import com.icaballero.rest.modelo.LineaPedido;
import com.icaballero.rest.modelo.Pedido;

@Component
public class PedidoDtoConverter {
	
	public GetPedidoDto convertPedidoToGetPedidoDto(Pedido pedido) {
		
		return GetPedidoDto.builder()
				.fullName(pedido.getCliente().getFullName())
				.avatar(pedido.getCliente().getAvatar())
				.email(pedido.getCliente().getEmail())
				.fecha(pedido.getFecha())
				.total(pedido.getTotal())
				.lineas(pedido.getLineas().stream()
							.map(this::convertLineaPedidoToGetLineaPedidoDto)
							.collect(Collectors.toSet())
						)
				.build();
		
		
	}
	
	public GetPedidoDto.GetLineaPedidoDto convertLineaPedidoToGetLineaPedidoDto(LineaPedido linea) {
		return GetPedidoDto.GetLineaPedidoDto.builder()
				.cantidad(linea.getCantidad())
				.precioUnitario(linea.getPrecio())
				.productoNombre(linea.getProducto().getNombre())
				.subTotal(linea.getSubtotal())
				.build();
	}

}
