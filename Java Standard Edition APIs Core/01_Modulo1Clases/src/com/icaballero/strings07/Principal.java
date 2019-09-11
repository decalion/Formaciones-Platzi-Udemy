package com.icaballero.strings07;



public class Principal {

	public static void main(String[] args) {
	
		//Solucion al problema de rendimiento Strings 
		
		long numero1 = System.currentTimeMillis();
		
		String cadena="Hola";
		System.out.println(cadena);
		
		//con string buffer no hay problemas de concurrencia
		StringBuffer sb  = new StringBuffer();
		sb.append(cadena);
		
		//Es igual que string buffer, puede tener problemas de cocurrencia y es mas rapida que string buffer
		StringBuilder sb1= new StringBuilder();
		
		
		
		for (int i = 0; i <50000; i++) {
			
			
			sb.append("Hola");
			sb.append(i);
			
		}
		
		long numero2 = System.currentTimeMillis();
		
		System.out.println(numero2-numero1);
		System.out.println(sb.toString());
		
		
		
		
		
		
		
		
		
		
		
		
			
	}
	

}
