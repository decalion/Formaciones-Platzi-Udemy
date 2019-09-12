package com.icaballero.interfaces04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Caja<T> implements Iterable<T> {

	protected List<T> lista = new ArrayList<T>();
	protected int tope;

	
	
	public void add(T elemento) {
	
		if (lista.size() < tope) {
			lista.add(elemento);
		}
	}

	public void borrar(T elemento) {
		lista.remove(elemento);
	}



	//Mayor naturalidad en cuanto a la gestion de las cajas
	//Implementando la interfaz Iterable podemos usar el foreach directamente
	//Sin tener que llamar al metodo getList
	@Override
	public Iterator<T> iterator() {
		
		return lista.iterator();
	}
	
	
	
	

}
