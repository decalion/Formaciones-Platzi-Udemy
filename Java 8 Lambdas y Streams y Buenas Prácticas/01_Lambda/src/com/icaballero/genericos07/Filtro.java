package com.icaballero.genericos07;



public interface Filtro<T> {
	
	
	public boolean test(T t);
	
	
	//Añade una clausula or sobre el filtro activo
	default public Filtro<T> or(Filtro<T> filtro) {
		
		return (T t) -> { return test(t) || filtro.test(t);};
	}

}
