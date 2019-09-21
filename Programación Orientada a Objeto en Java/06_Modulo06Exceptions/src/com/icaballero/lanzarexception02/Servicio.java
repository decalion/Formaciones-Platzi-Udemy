package com.icaballero.lanzarexception02;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servicio {

	static void miMetodo() throws Exception {
		File f  = new File("hola.txt");
		
		
		try {
			f.createNewFile();
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
			Date miFecha= df.parse("03/05-2017");
			
			System.out.println(miFecha);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			throw e;
			
		}finally {
			
			System.out.println("Cerrando los recursos");
		}
	}

}
