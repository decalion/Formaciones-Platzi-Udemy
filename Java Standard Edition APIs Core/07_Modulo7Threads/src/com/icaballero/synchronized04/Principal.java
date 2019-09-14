package com.icaballero.synchronized04;

public class Principal {

	public static void main(String[] args) {
		
		/**
		 * En este ejemplo  hemos añadido la palabra synchronized al metodo addDias para que los hilos se sincronizen
		 * 
		 * 5 dias de la tarea 1 mas 4 dias de la tarea 2 = 9 dias
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
