package com.icaballero.lambdas;

public class Main {

	public static void main(String[] args) {
		
		OnOneListener oneListener = new OnOneListener() {
			
			@Override
			public void onOne(String message) {
				System.out.println("ONE : " +message);
				
			}
		};
		
		//Ejemplo con lambdas
		OnOneListener oneListenr2 = (String message) -> {
			System.out.println("One lambda :) " + message);
		};
		
		oneListener.onOne("Sin lambda");
		oneListenr2.onOne("Con Lambda :) ");
		
		
		
		//Ejemplo lambadas 2
		
		OnOneListener oneListener3 = message -> System.out.println("Tu mensaje " + message);
		oneListener3.onOne(" Ejemplo 2");
		
		
		
		
		
	}
	
	
	}

	

