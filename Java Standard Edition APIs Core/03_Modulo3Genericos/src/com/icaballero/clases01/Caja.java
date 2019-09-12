package com.icaballero.clases01;

import java.util.ArrayList;
import java.util.List;

public class Caja<T> {

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

	
	
	
}
