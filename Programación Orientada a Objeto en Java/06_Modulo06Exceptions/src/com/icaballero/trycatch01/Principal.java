package com.icaballero.trycatch01;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Principal {
	
	
	public static void main(String[] args) {
		
		
		File f  = new File("N://hola.txt");
		
		
		try {
			f.createNewFile();
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
			Date miFecha= df.parse("03/05-2017");
			
			System.out.println(miFecha);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			
			System.out.println(e.getMessage());
		}finally {
			
			System.out.println("Cerrando los recursos");
		}
		
		
		
	}

}
