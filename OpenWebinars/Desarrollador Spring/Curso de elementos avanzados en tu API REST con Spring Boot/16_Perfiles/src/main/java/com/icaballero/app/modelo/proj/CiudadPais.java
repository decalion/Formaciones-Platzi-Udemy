package com.icaballero.app.modelo.proj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.icaballero.app.modelo.Ciudad;

@Projection(name = "ciudadPais", types = Ciudad.class)
public interface CiudadPais {

	String getNombre();
	
	@Value("#{target.getPais().getNombre()}")
	String getPais();
	
}
