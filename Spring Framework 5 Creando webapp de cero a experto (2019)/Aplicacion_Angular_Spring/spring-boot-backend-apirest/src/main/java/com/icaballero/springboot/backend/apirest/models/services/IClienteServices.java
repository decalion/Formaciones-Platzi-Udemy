package com.icaballero.springboot.backend.apirest.models.services;

import java.util.List;

import com.icaballero.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteServices {

	
	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	
	
	
}
