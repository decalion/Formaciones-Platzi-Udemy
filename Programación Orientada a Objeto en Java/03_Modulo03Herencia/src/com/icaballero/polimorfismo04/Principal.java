package com.icaballero.polimorfismo04;

public class Principal {
	
	public static void main(String[] args) {
		
		/**
		 * Ejemplo polimorfismo
		 */
		
		
		Persona p1= new Deportista("pedro");
		Persona p2= new Ingeniero("Anna");
		Deportista d1 = new Deportista("Angel");
		

		iniciarCaminoPersona(d1);
		iniciarCaminoPersona(p1);
		iniciarCaminoPersona(p2);

	}
	
	//Oculta una jerarquia de clases compleja
	//El programador que usa este metodo no necesita saber que existe el ingeniero y el deportista
	public static void iniciarCaminoPersona(Persona p) {
		p.andar();
	}
	

}
