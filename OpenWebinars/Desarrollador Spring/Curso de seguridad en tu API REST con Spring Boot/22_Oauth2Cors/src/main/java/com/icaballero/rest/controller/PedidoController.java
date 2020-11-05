package com.icaballero.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.icaballero.rest.dto.CreatePedidoDto;
import com.icaballero.rest.dto.GetPedidoDto;
import com.icaballero.rest.error.exceptions.PedidoNotFoundException;
import com.icaballero.rest.modelo.Pedido;
import com.icaballero.rest.service.PedidoServicio;
import com.icaballero.rest.util.pagination.PaginationLinksUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

	private final PedidoServicio pedidoServicio;
	private final PaginationLinksUtils paginationLinksUtils;
	
	
	@GetMapping("/")
	public ResponseEntity<?> pedidos(Pageable pageable, HttpServletRequest request) throws PedidoNotFoundException {
		Page<Pedido> result = pedidoServicio.findAll(pageable);
		
		
		if (result.isEmpty()) {
			throw new PedidoNotFoundException();
		} else {
			
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

			return ResponseEntity.ok().header("link", paginationLinksUtils.createLinkHeader(result, uriBuilder))
					.body(result);

			
			
		}
	}
	
	// TODO Pendiente de unir con la seguridad para poder obtener el usuario
	@PostMapping("/")
	public GetPedidoDto nuevoPedido(CreatePedidoDto pedido) {
		return null;
	}
	
	
	
}
