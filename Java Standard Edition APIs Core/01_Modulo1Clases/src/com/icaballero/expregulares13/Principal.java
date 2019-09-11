package com.icaballero.expregulares13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Principal {

	public static void main(String[] args) {
	
		//Ejemplo De Expresiones Regulares
		
		
		String mensaje = "Hola que tal estas es 10 de septiembre";
		
		//Parte la cadena con la letra a
		String[]  lista = mensaje.split("[a]");
		
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
		
		System.out.println();
		//Quita la letra E
		String[]  lista2 = mensaje.split("[e]");
		
		for (int i = 0; i < lista2.length; i++) {
			System.out.println(lista2[i]);
		}
		
		System.out.println();
		
		//Quita los espacios
		String[]  lista3 = mensaje.split("[\\s]");
		
		for (int i = 0; i < lista3.length; i++) {
			System.out.println(lista3[i]);
		}
		
		System.out.println();
		
		//Quitar cualquier vocal
		String[]  lista4 = mensaje.split("[aeiou]");
		
		for (int i = 0; i < lista4.length; i++) {
			System.out.println(lista4[i]);
		}
		
		System.out.println();
		
		//Cortar la cadena de la A a la D
		String[]  lista5 = mensaje.split("[a-d]");
		
		for (int i = 0; i < lista5.length; i++) {
			System.out.println(lista5[i]);
		}
		
		
		System.out.println();
		
		//Cortar los digitos
		String[]  lista6 = mensaje.split("\\d");
		
		for (int i = 0; i < lista6.length; i++) {
			System.out.println(lista6[i]);
		}
		
		
		
	System.out.println();
		
		//Cortar la cadena por 2 digitos
		String[]  lista7 = mensaje.split("\\d{2}");
		
		for (int i = 0; i < lista7.length; i++) {
			System.out.println(lista7[i]);
		}
		
		
		
	}
	

}
