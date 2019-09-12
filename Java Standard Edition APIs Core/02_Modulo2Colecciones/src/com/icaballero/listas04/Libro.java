package com.icaballero.listas04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Libro {

	
	private String titulo;
	private String autor;
	
	private List<Capitulo> listaCapitulos;
	
	
	public Libro(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.listaCapitulos = new ArrayList<Capitulo>();
	}
	
	
	
	/**
	 * Comprar si un capitulo esta en un libro
	 * @param c
	 * @return
	 */
	public boolean contieneCapitulo(Capitulo c) {
		
		return listaCapitulos.contains(c);
	}
	
	
	public boolean cambiarCapitulo(Capitulo viejo,Capitulo nuevo) {
		
		//Obtenemos la posicion del capitulo viejo
		int posicion = listaCapitulos.indexOf(viejo);
		
		//Remplazamos el capitulo nuevo en la posicion del viejo
		listaCapitulos.set(posicion, nuevo);
		
		if(posicion!=-1) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	
	/**
	 * Añade capitulos al libro
	 * @param c
	 */
	public void addCapitulo(Capitulo c) {
		listaCapitulos.add(c);
		
	}
	
	/**
	 * Devuelve la lista de capitulos
	 * @return
	 */
	public int totalCapitulos() {
		
		return listaCapitulos.size();
	}
	
	
	/**
	 * Devuelve el total de paginas de un libro
	 * @return
	 */
	public int totalPaginas() {
		
		int total = 0;
		
		/*
		Iterator<Capitulo> it = listaCapitulos.iterator();
		
		int total = 0;
		
		while(it.hasNext()) {
			Capitulo c = it.next();
			total+=c.getPagina();
		}*/
		
		//El foreach internamente usa iterator
		for (Capitulo c : listaCapitulos) {
			total+=c.getPagina();
			
		}
		
		
		return total;
	}
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}



	public List<Capitulo> getListaCapitulos() {
		return listaCapitulos;
	}
	
	
	
	
}
