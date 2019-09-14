package es.ejemplos.beans;

import org.springframework.stereotype.Service;

import es.ejemplos.beans.interfaces.Operacion;

@Service
public class Resta implements Operacion{
	int num1=5; 
	int num2=6;
	

	@Override
	public int calcular() {
		
		return num1-num2;
	}

}