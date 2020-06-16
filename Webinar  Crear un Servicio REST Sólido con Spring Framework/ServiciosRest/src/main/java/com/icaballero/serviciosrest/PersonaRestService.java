package com.icaballero.serviciosrest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/personas")
public class PersonaRestService {
	
	
	private static List<Persona> lista = new ArrayList<Persona>();
	
	static {
		Persona p1 = new Persona("ana", "gomez", 20);
		Persona p2 = new Persona("pepe", "perez", 25);
		lista.add(p1);
		lista.add(p2);
	}
	
	
	@GetMapping
	public List<PersonaDTO> buscarTodos(){
		//Convertimos en stream
		//Realiza Operacion map
		//usa un metodo de referencia sobre el constructor
		//conviertelo en un stream de PersonaDTO
		//Finalmente con un collector genera una nueva lista
		return lista
				.stream()
				.map(PersonaDTO::new)
				.collect(Collectors.toList());
	}
	
	//Definimos un parametro en la url
	@GetMapping("/{nombre}")
	public PersonaDTO buscarUno(@PathVariable String nombre) {
		
		//Programacion funcional
		return lista
				.stream()
				.filter(p->p.getNombre().equals(nombre))
				.findFirst()
				.map(PersonaDTO::new)
				.orElse(null);
		
	}
	
	//Haciendouso de http verbs borra una persona
	@DeleteMapping("/{nombre}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable String nombre) {
		
		lista.removeIf(p->p.getNombre().equals(nombre));
		
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<PersonaDTO> insertar(@RequestBody PersonaDTO personaDTO,UriComponentsBuilder builder) {
		
		Persona persona = new Persona(personaDTO.getNombre(),personaDTO.getApellidos(),personaDTO.getEdad());
		lista.add(persona);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(personaDTO);
		
		//Devuelve un enlace al nuevo recurso creado en el Header
//		HttpHeaders cabecera = new HttpHeaders();
//		UriComponents miUrl = builder.path("/personas/{nombre}").buildAndExpand(persona.getNombre());
//		cabecera.setLocation(miUrl.toUri());
//		
//		
//		return new ResponseEntity<Void>(cabecera,HttpStatus.CREATED);
//		
	}
	
	
	@PutMapping(value="/{nombre}")
	public ResponseEntity<Void> actualizar(@PathVariable String nombre,@RequestBody PersonaDTO personaDTO) {
		
		int posicion = lista.indexOf(new Persona(nombre));
		Persona persona = new Persona(personaDTO.getNombre(),personaDTO.getApellidos(),personaDTO.getEdad());
		//Si la persona existe actualiza
		if(posicion!=-1) {
			
			lista.set(posicion, persona);
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.build();
		} else {
			
			//Si no existe la crea
			
			lista.add(persona);
			
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.build();
		}
		
		
	}
	
	
	
	
	@PatchMapping(value="/{nombre}")
	public ResponseEntity<Void> actualizarParcial(@PathVariable String nombre,@RequestBody PersonaPartialDTO personaPartialDTO) {
		
		int posicion = lista.indexOf(new Persona(nombre));
		Persona persona = lista.get(posicion);
		persona.setApellidos(personaPartialDTO.getApellidos());
		persona.setEdad(personaPartialDTO.getEdad());
		
		
		if(posicion!=-1) {
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.build();
		} else {
			
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.build();
		}
		
		
	}
	
	
	
	
	
	

}
