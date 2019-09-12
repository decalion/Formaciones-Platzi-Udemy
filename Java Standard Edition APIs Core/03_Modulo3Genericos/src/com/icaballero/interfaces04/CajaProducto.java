package com.icaballero.interfaces04;

/**
 * El tipo T implementa l interfaz producto.
 * Solo se pueden definir objetos que implementen la interfaz producto.
 * @author ismael
 *
 * @param <T>
 */
public class CajaProducto<T extends Producto> extends Caja<T> {

	public CajaProducto(int tope) {
		super();
		this.tope = tope;
	}

	public double precioTotal() {
		
		double total=0;
		for(T mitipo: lista) {
			
			total+=mitipo.getPrecio();
		}
		
		return total;
	}
	
	
}
