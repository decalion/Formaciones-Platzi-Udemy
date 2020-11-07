package com.icaballero.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.icaballero.springboot.di.app.models.domain.ItemsFactura;
import com.icaballero.springboot.di.app.models.domain.Producto;
import com.icaballero.springboot.di.app.models.service.IServicio;
import com.icaballero.springboot.di.app.models.service.MiServicio;

@Configuration
public class AppConfig {
	
//	@Bean("miServicioSimple")
//	public IServicio registrarMiServicio() {
//		
//		return new MiServicio();
//	}
	
//	@Bean("miServicioComplejo")
//	@Primary
//	public IServicio registrarMiCompleo() {
//		
//		return new MiServicioComplejo();
//	}
	

	@Bean("itemsFactura")
	public List<ItemsFactura> registrarItems() {
		
		Producto producto1 = new Producto("Camara Sony", 100);
		Producto producto2 = new Producto("Bicicleta", 200);
		
		ItemsFactura linea1 = new ItemsFactura(producto1, 2);
		ItemsFactura linea2 = new ItemsFactura(producto2, 4);
		
		return Arrays.asList(linea1,linea2);
	}
	
	@Bean("itemsFacturaOficina")
	public List<ItemsFactura> registrarItemsOficina() {
		
		Producto producto1 = new Producto("Monitor LG 24", 250);
		Producto producto2 = new Producto("NootBook Asus", 500);
		Producto producto3 = new Producto("Impresora HP", 100);
		Producto producto4 = new Producto("Escritorio Oficina", 300);
		
		ItemsFactura linea1 = new ItemsFactura(producto1, 2);
		ItemsFactura linea2 = new ItemsFactura(producto2, 1);
		ItemsFactura linea3 = new ItemsFactura(producto3, 1);
		ItemsFactura linea4 = new ItemsFactura(producto4, 1);
		
		return Arrays.asList(linea1,linea2,linea3,linea4);
	}
	
	
	
}
