package com.icaballero.date11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Principal {

	public static void main(String[] args) {
	
		//Ejemplo SIMPLEDATEFORMAT
		
		String fechaTexto="10/12/2017";
		
		//patrones a nivel de api
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date fecha = df.parse(fechaTexto);
			System.out.println(fecha);
			
			//Convertir la fecha en cadena
			// MMMM sale el nombre del mes
			SimpleDateFormat df2 = new SimpleDateFormat("dd/MMMM/yyyy");
			System.out.println(df2.format(fecha));
			
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(fecha);
			System.out.println(calendario.get(Calendar.YEAR));
			System.out.println(calendario.get(Calendar.DAY_OF_MONTH));
			// EL MES VA de 0 a 11
			System.out.println(calendario.get(Calendar.MONTH));
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
