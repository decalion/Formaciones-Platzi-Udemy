package com.icaballero.strings06;



public class Principal {

	public static void main(String[] args) {
	
		//Strings Rendimiento
		
		long numero1 = System.currentTimeMillis();
		
		String cadena="Hola";
		System.out.println(cadena);
		
		//Se ejecuta pero rinde mal
		for (int i = 0; i <50000; i++) {
			
		/**
		 * Un string cada vez que concatena genera una cadena
		 * por ejemplo "hola"+""que"+"tal"+"estas"
		 * Genera 7 cadenas
		 * por un lado tenemos la cadena1 Hola , cadena2 que, cadena3 tal y cadena4 estas
		 * despues se genera la cadena5 Hola que y la cadena6 tal estas
		 * y para finalizar la cadena7 Hola que tal estas
		 * En este caso en el bucle for estamos haciendo 50000 vueltas concatenando cadenas esto hace que el rendimiento sea muy malo.
		 * 	
		 */
			
			cadena=cadena+"hola"+i;
			
		}
		
		long numero2 = System.currentTimeMillis();
		
		System.out.println(numero2-numero1);
		
		
		
		
		
		
		
		
		
		
		
		
		
			
	}
	

}
