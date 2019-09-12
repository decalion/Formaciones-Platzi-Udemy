package com.icaballero.referencias06;

public class Libro {
	
	private String titulo;
	private int precio;
	private String categoria;
	private int paginas;
	

	public Libro(String titulo, int precio, String categoria, int paginas) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.categoria = categoria;
		this.paginas = paginas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	
	
	
	
	
	
	

}
