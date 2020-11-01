package com.icaballero.app.dto.converter;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.icaballero.app.dto.ProductoDTO;
import com.icaballero.app.modelo.Producto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductoDTOConverter {
	
	private final ModelMapper modelMapper;
	
	
	@PostConstruct
	public void init() {
		modelMapper.addMappings(new PropertyMap<Producto, ProductoDTO>() {

			@Override
			protected void configure() {
				map().setCategoria(source.getCategoria().getNombre());
			}
		});
	}
	
	public ProductoDTO convertToDto(Producto producto) {
		return modelMapper.map(producto, ProductoDTO.class);
		
	}

}
