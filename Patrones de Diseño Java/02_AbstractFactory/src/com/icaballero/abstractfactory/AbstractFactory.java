package com.icaballero.abstractfactory;

public interface AbstractFactory<T> {
	
	T create(String type);
	
	
	

}
