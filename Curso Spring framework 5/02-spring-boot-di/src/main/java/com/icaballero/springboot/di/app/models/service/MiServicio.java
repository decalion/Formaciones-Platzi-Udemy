package com.icaballero.springboot.di.app.models.service;

import org.springframework.stereotype.Service;

@Service("miServicioSimple")
public class MiServicio implements IServicio {
	
	@Override
	public String operacion() {
		
		return "Ejecutando algun proceso importante Simple...";
	}

}
