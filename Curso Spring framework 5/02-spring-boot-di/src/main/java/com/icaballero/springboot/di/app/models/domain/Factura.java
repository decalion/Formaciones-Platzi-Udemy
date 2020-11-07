package com.icaballero.springboot.di.app.models.domain;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class Factura {
	
	@Value("${descripcion.factura}")
	private String descripcion;

	@Autowired
	private Cliente cliente;

	@Autowired
	@Qualifier("itemsFacturaOficina")
	private List<ItemsFactura> items;
	
	@PostConstruct
	public void init() {
		//Se ejecuta despues de construir el objeto
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Pepe"));
	}
	
	@PreDestroy
	public void destroy() {
		//Se ejecuta cuando se destruye la clase
		
		System.out.println("Factura destruida");
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemsFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemsFactura> items) {
		this.items = items;
	}

}
