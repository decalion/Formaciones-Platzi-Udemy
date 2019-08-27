package com.icaballero.springboot.webflux.app;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.icaballero.springboot.webflux.app.models.dao.IProductoDao;
import com.icaballero.springboot.webflux.app.models.documents.Producto;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootWebfluxApplication implements CommandLineRunner {

	@Autowired
	private IProductoDao dao;
	
	@Autowired
	private ReactiveMongoTemplate mongoTemplate; 
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootWebfluxApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		mongoTemplate.dropCollection("productos").subscribe();
		
		Flux.just( new Producto("TV Panasoni Patalla LCD", 456.89),
				  new Producto("Sony Camara HD Digital", 177.89),
				  new Producto("Apple iPod" , 46.89),
				  new Producto("Sony NoteBook", 846.89),
				  new Producto("Hewlett Bicicleta", 200.89),
				  new Producto("Bianchi Bicicleta", 70.89),
				  new Producto("MAC NOTEBOOK", 1200.60),
				  new Producto("MSI Portatil Gaming", 2000.40)
				)
				.flatMap(producto -> {
					
					producto.setCreateAt(new Date());
					
					return dao.save(producto);
					
				})
		        .subscribe(producto -> log.info("Insert " + producto.getId() + " " + producto.getNombre()));
		
	}
	
	

}
