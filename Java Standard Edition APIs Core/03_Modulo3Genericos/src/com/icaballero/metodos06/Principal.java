package com.icaballero.metodos06;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		Persona p = new Persona();
		p.setNombre("pepe");
		Ingeniero i = new Ingeniero();
		i.setNombre("ana");

		List<Persona> lista = new ArrayList<Persona>();
		lista.add(p);
		lista.add(i);
		
		List<Ingeniero> lista2 = new ArrayList<Ingeniero>();
		lista2.add(i);

		
		//Forma correcta
		andarTodas(lista2);
		andarTodas(lista);
		
		
		List<Persona> otraLista = clonarList(lista);
		
		
		for (Persona pNueva : otraLista) {
			
			System.out.println(pNueva.getNombre());
			
		}
		
		
		
	}
	

	//Forma correcta
	//Ahora admite listas tanto de personas como ingenieros como deportistas
	public static void andarTodas(List<? extends Persona> milista) {
		
		for (Persona p : milista) {
			p.andar();
			
		}
	}
	
	
	/**
	 * Ejemplo de metodo generico
	 * @param <T>
	 * @param milista
	 * @return
	 */
	public static <T> List<T> clonarList(List<T> milista){
		
		List<T> milistaNueva = new ArrayList<T>();
		
		milistaNueva.addAll(milista);
		
		return milistaNueva;
	}


}
