package com.icaballero.gestionestados03;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * En este ejemplo los dias no se actualizan bien ya que los hilos no estan sincronizados
		 */
		
		Trabajador t = new Trabajador(0);
		
		Tarea miTarea = new Tarea(t, 5);
		
		Thread hilo = new Thread(miTarea);
		hilo.start();
		

		Tarea miTarea2 = new Tarea(t, 4);
		Thread hilo2 = new Thread(miTarea2);
		hilo2.start();
	}

}
