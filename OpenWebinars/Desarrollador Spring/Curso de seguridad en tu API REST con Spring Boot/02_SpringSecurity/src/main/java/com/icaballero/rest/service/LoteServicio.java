package com.icaballero.rest.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.icaballero.rest.dto.CreateLoteDTO;
import com.icaballero.rest.error.LoteCreateException;
import com.icaballero.rest.modelo.Lote;
import com.icaballero.rest.repos.LoteRepositorio;
import com.icaballero.rest.service.base.BaseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoteServicio extends BaseService<Lote, Long, LoteRepositorio> {

	private final ProductoServicio productoServicio;
	
	@Override
	public Optional<Lote> findById(Long id) {
		return repositorio.findByIdJoinFetch(id);
	}

	public Lote nuevoLote(CreateLoteDTO nuevoLote) {
		
		Lote l = Lote.builder()
					.nombre(nuevoLote.getNombre())
					.build();
		
		nuevoLote.getProductos().stream()
			.map(id -> {
				return productoServicio.findByIdConLotes(id).orElseThrow(() -> new LoteCreateException());
			})
			.forEach(l::addProducto);
			
		return save(l);
		
	}
	
	

}
