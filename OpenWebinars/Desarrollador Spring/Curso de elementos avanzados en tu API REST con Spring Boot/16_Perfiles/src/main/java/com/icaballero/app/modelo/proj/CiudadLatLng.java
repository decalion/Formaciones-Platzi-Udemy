package com.icaballero.app.modelo.proj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.icaballero.app.modelo.Ciudad;

@Projection(name = "ciudadLatLng", types = {Ciudad.class})
public interface CiudadLatLng {
	
	@Value("#{target.id}")
	long getId();
	
	String getNombre();
	
	@Value("#{target.lat}#{','}#{target.lng}")
	String getCoordenadas();
	
	@Value("#{target.getPais().getNombre()}")
	String getPais();

}
