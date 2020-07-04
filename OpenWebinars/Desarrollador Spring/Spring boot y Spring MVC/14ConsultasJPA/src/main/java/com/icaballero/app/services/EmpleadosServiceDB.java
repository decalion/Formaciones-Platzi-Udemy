package com.icaballero.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icaballero.app.models.Empleado;
import com.icaballero.app.repository.EmpleadoRepository;

@Service("empleadoServiceDB")
public class EmpleadosServiceDB implements EmpleadosService{


	
	@Autowired
	private EmpleadoRepository repositorio;

	@Override
	public Empleado add(Empleado e) {
		return repositorio.save(e);
	}

	@Override
	public List<Empleado> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Empleado findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public Empleado edit(Empleado e) {
		return repositorio.save(e);
	}
	
	public void delete(Empleado e) {
		repositorio.delete(e);
	}

	public List<Empleado> buscador(String cadena) {
		// return repositorio.findByNombreContainsIgnoreCaseOrEmailContainsIgnoreCaseOrTelefonoContainsIgnoreCase(cadena, cadena, cadena);
		//return repositorio.encuentraPorNombreEmailOTelefono(cadena.toLowerCase());
		return repositorio.encuentraPorNombreEmailOTelefonoNativa(cadena.toLowerCase());
	}
	
}
