package com.icaballero.orderapi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icaballero.orderapi.entity.Product;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloWorldController {
	
	//private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
	
	@GetMapping(value = "hello")
	public String hello() {
		
		return "Hello World";
	}
	
//	
//	@GetMapping(value = "products")
//	public Product findProduct() {
//		log.info("findProduct() =>");
//		
//		Product product = new Product();
//		product.setId(1L);
//		product.setName("Producto 1");
//
//		
//		return product;
//		
//		
//	}

}
