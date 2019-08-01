/**
 * 
 */
package com.icaballero.ereservation.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icaballero.ereservation.modelo.Cliente;

/**
 * Interfaz para definir las operaciones de BBDD relacionadas con cliente
 * @author ismael
 *
 */
public interface ClienteRepository  extends JpaRepository<Cliente, String>{
	
	/**
	 * 
	 * @param apellidoCli
	 * @return
	 */
	public List<Cliente> findByApellidoCli(String apellidoCli);
	
	/**
	 * 
	 * @param identificacionCli
	 * @return
	 */
	public Cliente findByIdentificacion(String identificacionCli);

	
	
}
