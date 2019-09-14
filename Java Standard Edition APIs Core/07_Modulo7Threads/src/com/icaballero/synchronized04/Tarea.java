package com.icaballero.synchronized04;

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
			
			System.out.println(trabajador.addDia());
		}
		
	}
	
	
	
	
	
	
	
	
	

}
