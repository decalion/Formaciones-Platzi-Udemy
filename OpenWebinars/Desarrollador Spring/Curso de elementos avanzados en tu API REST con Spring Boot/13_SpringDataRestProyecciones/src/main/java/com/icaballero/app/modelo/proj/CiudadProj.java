package com.icaballero.app.modelo.proj;

import org.springframework.data.rest.core.config.Projection;

import com.icaballero.app.modelo.Ciudad;

@Projection(name = "ciudadSinUbicacion", types = { Ciudad.class })
public interface CiudadProj {

	String getNombre();
	
}
