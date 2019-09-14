package com.icaballero.waitnotify07;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * Ejemplo de Wait / Notify
		 * Observadores y Observable
		 * 
		 * 
		 */
		
		
		long t1 = System.currentTimeMillis();
		
		Trabajador t = new Trabajador(0);
		
		Tarea miTarea = new Tarea(t, 5);
		
		Thread hilo = new Thread(miTarea);
		hilo.start();
		

		Tarea miTarea2 = new Tarea(t, 4);
		Thread hilo2 = new Thread(miTarea2);
		hilo2.start();
		
		
		try {
			
			hilo.join();
			hilo2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		long t2= System.currentTimeMillis();
		
		/**
		 * Como los hilos estan con el join esto se mostrara lo ultimo
		 */
		
		System.out.println(t2-t1);
		
		
	}

}
