package com.icaballero.expregulares14;

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

		String[]  lista = mensaje.split("\\d{2}");
		
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
		
		
		String textoCientes="El cliente A tiene de clave clave1234"
				+ ", el cliente B tiene clave otraClave3425";
		
		//Remplazar las claves
		//letras de la A la Z , entre 3 O 10 letras seguidas de 4 digitos
		String nuevoTexto = textoCientes.replaceAll("[a-zA-Z]{3,10}\\d{4}", "XXXXXXXX");
		
		System.out.println(nuevoTexto);
		
		
		
		
		
		
		
		
	}
	

}
