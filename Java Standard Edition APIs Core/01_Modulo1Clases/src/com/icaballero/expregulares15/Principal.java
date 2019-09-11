package com.icaballero.expregulares15;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Principal {

	public static void main(String[] args) {
	
		//Ejemplo De Expresiones Regulares
		
		String textoFacturas="las facturas son 123AB y 234CB";
			
		//3 digitos seguidos de 2 letras mayusculas de la A a la Z	
		String expresion="\\d{3}[A-Z]{2}";
	
		//Expresion regular compilada
		Pattern patron = Pattern.compile(expresion);
		
		Matcher coincidencias = patron.matcher(textoFacturas);
		
		//System.out.println(coincidencias.find());
		
		
		while(coincidencias.find()) {
			//Limita el texto que coincide con la expresion regular
			int inicio = coincidencias.start();
			int fin = coincidencias.end();
			
			System.out.println(textoFacturas.substring(inicio,fin));
		}
		
		
	}
	

}
