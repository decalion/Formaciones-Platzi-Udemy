package com.icaballero.date10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Principal {

	public static void main(String[] args) {
	
		//Ejemplo SIMPLEDATEFORMAT
		
		String fechaTexto="10/12/2016";
		
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/YYYY");
		
		try {
			
			Date miFecha = f.parse(fechaTexto);
			
			Calendar calendario = Calendar.getInstance();
			
			calendario.setTime(miFecha);
			
			System.out.println(calendario.get(Calendar.YEAR));
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
