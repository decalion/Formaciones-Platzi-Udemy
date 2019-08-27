package com.icaballero.springboot.webflux.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icaballero.springboot.webflux.app.models.dao.IProductoDao;
import com.icaballero.springboot.webflux.app.models.documents.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {
	
	@Autowired
	private IProductoDao dao;
	
	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
	

	@GetMapping()
	public Flux<Producto> index(){
		
		
		Flux<Producto> productos = dao.findAll()
				.map(producto ->{
					
					producto.setNombre(producto.getNombre().toUpperCase());
					return producto;
				}).doOnNext(prod -> log.info(prod.getNombre()));
		
		
		return productos;
		
	}
	
	@GetMapping("/{id}")
	public Mono<Producto> show(@PathVariable String id){
		
		//Mono<Producto> productos = dao.findAllById(id);
		
		Flux<Producto> productos = dao.findAll();
		
		Mono<Producto> producto = productos.filter(p -> p.getId().equals(id))
				.next()
				.doOnNext(prod -> log.info(prod.getNombre()));
		
		return producto;
	}
	
	
	
}
