/**
 * 
 */
package com.icaballero.ereservation.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icaballero.ereservation.modelo.Cliente;
import com.icaballero.ereservation.negocio.repository.ClienteRepository;

/**
 * Clase para definir los servicios del cliente
 * 
 * @author ismael
 *
 */
@Service
@Transactional(readOnly = true)
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;

	}

	/**
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente create(Cliente cliente) {

		return this.clienteRepository.save(cliente);
	}

	/**
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente cliente) {

		return this.clienteRepository.save(cliente);
	}

	/**
	 * 
	 * @param cliente
	 */
	@Transactional
	public void deleted(Cliente cliente) {

		this.clienteRepository.delete(cliente);
	}

	/**
	 * 
	 * @param identificacionCli
	 * @return
	 */
	public Cliente findByIdentificacion(String identificacionCli) {

		return this.clienteRepository.findByIdentificacion(identificacionCli);
	}
	
	public List<Cliente> findAll(){
		
		return this.clienteRepository.findAll();
	}
}
