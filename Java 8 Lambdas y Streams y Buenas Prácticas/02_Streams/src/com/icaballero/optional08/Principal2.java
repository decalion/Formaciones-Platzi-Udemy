package com.icaballero.optional08;

import java.util.Optional;
import java.util.OptionalInt;

import com.icaballero.stream01.Persona;

public class Principal2 {

	public static void main(String[] args) {
		
		
		//Los Java Optional sirven para envolver objetos y comprobar 
		//que de ver existe el objeto que no es NULL
		
		//EJEMPLO SIN OPTIONAL
		
		//Persona p1=new Persona("Juan", "Sanchez", 20);
//		Persona p1=null;
//		
//		if (p1!=null) {
//			System.out.println(p1.getNombre());
//		}
//		
//		
		
		//EJEMPLO CON OPTIONAL
		//Los tipos optional nos ayudan a gestionar los nullpointerexception
		
		//Optional<Persona> op1 =Optional.empty();//optional vacio
		Optional<Persona> op1 =Optional.of(new Persona("Juan", "Sanchez", 20));
		if(op1.isPresent()) {
			System.out.println(op1.get().getNombre());
		}
		
		
		
	
	}
	

	
	
}
