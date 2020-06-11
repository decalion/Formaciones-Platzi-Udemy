package com.icaballero.defaultmethod02;

import java.util.List;
import java.util.function.Consumer;

import com.icaballero.consumer01.Persona;
import com.icaballero.consumer01.ServicioPersona;



public class Principal {

	
	public static void main(String[] args) {
		
		
		ServicioPersona servicio = new ServicioPersona();
		List<Persona> lista = servicio.buscarTodos();
		
		//EJEMPLO DE INTERFAZ CONSUMER
		//Un Consumidor Recibe un parametro y no devuelve nada
		//Un consumer no tiene que tener un return
		Consumer<Persona> consumerNombre = (p) ->System.out.println(p.getNombre());
		
		Consumer<Persona> consumerApellidos =Principal::imprimirApellidos;
		
		
	
		

//		lista.stream().forEach(consumerNombre);
//		lista.stream().forEach(consumerApellidos);
//		lista.stream().forEach(Principal::imprimirApellidos);
		
		//Consumidor combinado que imnprime nombre y apellidos
		Consumer<Persona> consumerCombinado = consumerNombre.andThen(consumerApellidos);
		consumerCombinado.accept(new Persona("antonio", "Jimenez", 50));
		
		//El metodo accept s ejecuta cuando invocamos una estructura forwach
		//consumerApellidos.accept(new Persona("antonio", "Jimenez", 50));
		
		

	}
	
	
	
	//Puede ser asociado auna funcionon consumer (Recibe la persona y no devuelve nada)
	public static void imprimirApellidos(Persona persona) {
		
		System.out.println(persona.getApellido());
	}
	
	
	
	public static void imprimirNombre(Persona persona) {
		
		System.out.println(persona.getNombre());
	}

	
	
	
	
	

}
