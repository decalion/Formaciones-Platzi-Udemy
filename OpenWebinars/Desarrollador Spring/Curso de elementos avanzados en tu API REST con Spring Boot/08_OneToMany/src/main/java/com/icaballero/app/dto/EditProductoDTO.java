package com.icaballero.app.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class EditProductoDTO {

	private String nombre;
	private float precio;
	
}
