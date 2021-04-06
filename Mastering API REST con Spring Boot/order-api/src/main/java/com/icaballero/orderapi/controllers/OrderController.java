package com.icaballero.orderapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icaballero.orderapi.converters.OrderConverter;
import com.icaballero.orderapi.dtos.OrderDTO;
import com.icaballero.orderapi.entity.Order;
import com.icaballero.orderapi.service.IOrderService;
import com.icaballero.orderapi.utils.PathConstants;
import com.icaballero.orderapi.utils.WrapperResponse;

@RestController
public class OrderController {

	@Autowired
	private OrderConverter converter;

	@Autowired
	private IOrderService orderService;

	@GetMapping(value = PathConstants.ORDERS)
	public ResponseEntity<WrapperResponse<List<OrderDTO>>> findAll(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize) {

		Pageable page = PageRequest.of(pageNumber, pageSize);

		List<Order> orders = orderService.findAll(page);

		return new WrapperResponse<List<OrderDTO>>(true, "succes", converter.fromEntity(orders))
				.createResponse(HttpStatus.OK);
	}

	@GetMapping(value = PathConstants.ORDERS_ID)
	public ResponseEntity<WrapperResponse<OrderDTO>> findById(@PathVariable(name = "id") Long id) {

		Order order = orderService.findById(id);

		return new WrapperResponse<OrderDTO>(true, "succes", converter.fromEntity(order)).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = PathConstants.ORDERS)
	public ResponseEntity<WrapperResponse<OrderDTO>> create(@RequestBody OrderDTO order) {


		Order newOrder = orderService.save(converter.fromDTO(order));

		return new WrapperResponse<OrderDTO>(true, "succes", converter.fromEntity(newOrder))
				.createResponse(HttpStatus.CREATED);
	}

	@PutMapping(value = PathConstants.ORDERS)
	public ResponseEntity<WrapperResponse<OrderDTO>> update(@RequestBody OrderDTO order) {

		converter.fromDTO(order);
		Order updateOrder = orderService.save(converter.fromDTO(order));

		return new WrapperResponse<OrderDTO>(true, "succes", converter.fromEntity(updateOrder))
				.createResponse(HttpStatus.CREATED);
	}

	@DeleteMapping(value = PathConstants.ORDERS_ID)
	public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {

		orderService.delete(id);
		
		return new WrapperResponse(true, "succes", null).createResponse(HttpStatus.OK);
	}

}
