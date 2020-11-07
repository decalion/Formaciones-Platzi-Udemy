package com.icaballero.springboot.di.app.models.domain;

public class ItemsFactura {

	private Producto producto;
	private Integer cantidad;
	
	
	
	

	public ItemsFactura(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Integer calcularImporte() {
		
		return cantidad * producto.getPrecio();
	}

}
