package com.icaballero.personalizadas03;

public class Principal {
	
	
	public static void main(String[] args) {
		
		
		try {
			Servicio.miMetodo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e.getMessage());
		}
		
		
		
	}

}
