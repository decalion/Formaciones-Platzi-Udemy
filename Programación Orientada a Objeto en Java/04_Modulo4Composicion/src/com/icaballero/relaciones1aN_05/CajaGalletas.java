package com.icaballero.relaciones1aN_05;

import java.util.ArrayList;

public class CajaGalletas {

	private ArrayList<Galleta> galletas;

	
	
	public CajaGalletas() {
		
		galletas = new ArrayList<Galleta>();
	}

	
	
	public ArrayList<Galleta> getGalletas() {
		return galletas;
	}

	public void setGalletas(ArrayList<Galleta> galletas) {
		this.galletas = galletas;
	}
	
	
	public void addGalleta(Galleta galleta) {
		//Delegamos en el arraylist para añadir galletas
		galletas.add(galleta);
	}
	
	//Sobrecarga de metodo + delegacion
	public void addGalleta(String sabor, double precio) {
		
		galletas.add(new Galleta(sabor, precio));
	}
	
	
	public int totalGalletas() {
		
		return galletas.size();
	}
	
	
	//Delegacion para calcular el total de precio
	public double precioTotal() {
		
		double total=0;
		
		for (Galleta galleta : galletas) {
			
			total+=galleta.getPrecio();
			
		}
		
		//DEVULVE EL TOTAL DE LAS GALLETAS + 1 EURO DE LA CAJA
		
		return total+1;
		
	}
	
}
