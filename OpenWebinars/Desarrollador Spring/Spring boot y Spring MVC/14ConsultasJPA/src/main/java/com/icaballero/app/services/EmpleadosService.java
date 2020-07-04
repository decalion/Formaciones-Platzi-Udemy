package com.icaballero.app.services;

import java.util.List;

import com.icaballero.app.models.Empleado;

public interface EmpleadosService {
	
	public Empleado add(Empleado e);
	public List<Empleado> findAll();
	public Empleado findById(Long id);
	public Empleado edit(Empleado e);

}
