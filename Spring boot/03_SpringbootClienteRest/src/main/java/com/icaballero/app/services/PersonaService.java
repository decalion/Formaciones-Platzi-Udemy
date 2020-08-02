package com.icaballero.app.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.icaballero.app.vo.PersonaVO;

@Service
public class PersonaService {

	private RestTemplate restTemplate = new RestTemplate();

	/**
	 * 
	 * @return
	 */
	public Iterable<PersonaVO> buscarTodos() {

		ResponseEntity<List<PersonaVO>> respuesta = restTemplate.exchange("http://localhost:8080/webapi/personas",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonaVO>>() {
				});

		List<PersonaVO> personas = respuesta.getBody();

		return personas;

	}

	/**
	 * 
	 * @param persona
	 */
	public void borrar(PersonaVO persona) {

		restTemplate.delete("http://localhost:8080/webapi/personas/" + persona.getNombre());
	}

	/**
	 * 
	 * @param persona
	 */
	public void insertar(PersonaVO persona) {

		HttpEntity<PersonaVO> peticion = new HttpEntity<PersonaVO>(persona);

		restTemplate.postForObject("http://localhost:8080/webapi/personas", peticion, PersonaVO.class);
	}

}
