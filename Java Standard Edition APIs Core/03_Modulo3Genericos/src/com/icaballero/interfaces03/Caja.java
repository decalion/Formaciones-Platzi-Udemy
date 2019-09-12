package com.icaballero.interfaces03;

import java.util.ArrayList;
import java.util.List;

/**
 * El tipo T implementa l interfaz producto.
 * Solo se pueden definir objetos que implementen la interfaz producto.
 * @author ismael
 *
 * @param <T>
 */
public class Caja<T extends Producto> {

	private List<T> lista = new ArrayList<T>();
	//Definir el tope 
	private int tope;

	public Caja(int tope) {
		super();
		this.tope = tope;
	}

	//Metodo para añadir siempre que sea menor que el tope
	public void add(T elemento) {

		if (lista.size() < tope) {
			lista.add(elemento);
		}
	}

	//metodo para borrar
	public void borrar(T elemento) {
		lista.remove(elemento);
	}

	
	public List<T> getLista() {
		return lista;
	}

	public double precioTotal() {
		
		double total=0;
		for(T mitipo: lista) {
			
			total+=mitipo.getPrecio();
		}
		
		return total;
	}
	
	
}
