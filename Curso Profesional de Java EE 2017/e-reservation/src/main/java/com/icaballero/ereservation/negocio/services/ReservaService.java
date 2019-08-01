/**
 * 
 */
package com.icaballero.ereservation.negocio.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icaballero.ereservation.modelo.Reserva;
import com.icaballero.ereservation.negocio.repository.ReservaRepository;

/**
 * @author ismael
 *
 */

@Service
@Transactional(readOnly = true)
public class ReservaService {
	
	private final ReservaRepository reservaRepository;

	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	/**
	 * 
	 * @param reserva
	 * @return
	 */
	@Transactional
	public Reserva create(Reserva reserva) {
		
		return this.reservaRepository.save(reserva);
	}
	
	/**
	 * 
	 * @param reserva
	 * @return
	 */
	@Transactional
	public Reserva update(Reserva reserva) {
		
		return this.reservaRepository.save(reserva);
	}
	
	/**
	 * 
	 * @param reserva
	 */
	@Transactional
	public void deleted(Reserva reserva) {
		this.reservaRepository.delete(reserva);
	}
	
	/**
	 * 
	 * @param fechaInicio
	 * @param fechaSalida
	 * @return
	 */
	public List<Reserva> find(Date fechaInicio ,Date fechaSalida){
		
		return this.reservaRepository.find(fechaInicio, fechaSalida);
	}

}
