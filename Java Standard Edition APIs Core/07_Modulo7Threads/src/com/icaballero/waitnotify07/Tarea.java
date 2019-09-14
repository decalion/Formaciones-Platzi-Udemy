package com.icaballero.waitnotify07;

public class Tarea implements Runnable {
	
	
	private Trabajador trabajador;
	private int dias;
	
	
	
	
	
	
	public Tarea(Trabajador trabajador, int dias) {
		super();
		this.trabajador = trabajador;
		this.dias = dias;
	}
	public Trabajador getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	
	
	
	
	@Override
	public void run() {
		
		for (int i = 0; i < dias; i++) {
			/**
			 * Si utilzamos el wait y el notifyd tambien tenemos que sincronizar esta operacion
			 */
			synchronized (trabajador) {
				System.out.println(trabajador.addDia());
				
			}
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	

}
