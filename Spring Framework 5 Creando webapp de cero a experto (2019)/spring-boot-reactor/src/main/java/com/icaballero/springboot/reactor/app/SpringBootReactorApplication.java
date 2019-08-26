package com.icaballero.springboot.reactor.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.icaballero.springboot.reactor.app.models.Usuario;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootReactorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Flux<String> nombres = Flux.just("Ismael Caballero", "Cristian Bautista", "Gerard Exposito","Lucy HeathFilia", "Gus Montes","Natsu Dragnel","Luffy D","Lucy Dragnel");
		
		
				nombres.map(nombre -> new Usuario(nombre.split(" ")[0].toUpperCase(),nombre.split(" ")[1]))
				.filter( usuario -> 
				{ 
					return usuario.getNombre().toLowerCase().equals("lucy");
				
				})
		       .doOnNext(usuario -> {

		    	   if (usuario == null) {
		    		   throw new RuntimeException("Nombres no puede estar vacio");
		    	   }
		    		   System.out.println(usuario.toString());
		    	   
		       })
		       .map(usuario -> {
		    	   String nombre = usuario.getNombre().toLowerCase();
		    	   usuario.setNombre(nombre);
		    	   return usuario;
		       });
		
		
				

		nombres.subscribe(e -> log.info(e.toString()), 
				error -> log.error(error.getMessage()),
				new Runnable() {
					
					@Override
					public void run() {
						log.info("Ha finalizado la ejecucion del observable con exito!");
						
					}
				});
	}

}
