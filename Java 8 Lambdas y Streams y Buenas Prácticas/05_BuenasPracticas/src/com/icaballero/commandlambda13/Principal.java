package com.icaballero.commandlambda13;



import java.util.stream.Stream;

import com.icaballero.sorting01.Factura;

public class Principal {

	
	public static void main(String[] args) {

		Factura f = new Factura(1,"ordenador",200);
		Factura f2 = new Factura(1,"ordenador",200);
		Factura f3 = new Factura(1,"ordenador",200);
		Factura f4 = new Factura(1,"ordenador",200);

	long t1 = System.currentTimeMillis();
	CommandManager manager = new CommandManager();

	//of Construye un stream a partir de elementos
	Stream<Factura> mistream = Stream.of(f,f2,f3,f4);
	
	mistream.
	parallel().
	peek(CommandManager::email).
	peek(CommandManager::guardar).
	peek(CommandManager::imprimir).
	forEach( (factura) -> System.out.println("Terminar"));
	
	long t2 = System.currentTimeMillis();
	
	System.out.println(t2-t1);
	
	
	

	
	
	

	}
	

		
	

}
