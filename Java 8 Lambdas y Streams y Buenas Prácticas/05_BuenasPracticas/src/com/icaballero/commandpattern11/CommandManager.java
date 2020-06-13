package com.icaballero.commandpattern11;

import java.util.ArrayList;
import java.util.List;

import com.icaballero.sorting01.Factura;

public class CommandManager implements ComandoFactura {
	
	List<ComandoFactura> lista = new ArrayList<ComandoFactura>();
	
	
	public void add (ComandoFactura comando) {
		lista.add(comando);
	}
	
	
	public Factura execute(Factura factura) {
		
		for (ComandoFactura c : lista) {
			
			c.execute(factura);
			
		}
		
		return factura;
	}
	
	

}
