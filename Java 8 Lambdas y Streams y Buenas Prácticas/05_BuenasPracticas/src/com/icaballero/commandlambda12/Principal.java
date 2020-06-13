package com.icaballero.commandlambda12;



import java.util.stream.Stream;

import com.icaballero.sorting01.Factura;

public class Principal {

	
	public static void main(String[] args) {

		Factura f = new Factura(1,"ordenador",200);

	
	CommandManager manager = new CommandManager();

	//of Construye un stream a partir de elementos
	Stream<Factura> mistream = Stream.of(f);
	
	mistream.
	peek(CommandManager::email).
	peek(CommandManager::guardar).
	peek(CommandManager::imprimir).
	forEach( (factura) -> System.out.println("Terminar"));
	
	
	

	
	
	

	}
	

		
	

}
