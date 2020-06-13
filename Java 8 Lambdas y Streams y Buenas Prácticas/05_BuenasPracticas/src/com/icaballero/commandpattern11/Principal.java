package com.icaballero.commandpattern11;



import com.icaballero.sorting01.Factura;

public class Principal {

	
	public static void main(String[] args) {

	ComandoFactura cf= new ComandoImprimir();
	ComandoFactura cg= new ComandoGuardar();
	ComandoFactura ce= new ComandoEmail();
	
	//cf.execute(cg.execute(ce.execute(new Factura(1,"ordenador",200))));
	
	CommandManager manager = new CommandManager();
	manager.add(cf);
	manager.add(cg);
	manager.add(ce);
	
	manager.execute(new Factura(1,"ordenador",200));
	
	
//	cf.execute(new Factura(1,"ordenador",200));
//	cg.execute(new Factura(2,"televisor",500));
//	ce.execute(new Factura(3,"movil",800));
//	
	
	
	

	}
	

		
	

}
