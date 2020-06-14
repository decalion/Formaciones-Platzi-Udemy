package com.icaballero.test;

import static org.junit.Assert.assertEquals;



import org.junit.Before;
import org.junit.Test;

import com.icaballero.bo.Comentario;

import com.icaballero.repositorios.jpa.ComentarioRepositoryJPA;


public class ComentarioRepositoryTest extends JPAUnitTest {
	
	ComentarioRepositoryJPA repositorio;
	
	@Before
	public void setup() {
		super.setup();
		repositorio = new ComentarioRepositoryJPA();
		repositorio.setEntityManager(em);
	}
	
	@Test
	public void inyectarEntityManager() {
		assertEquals(em, repositorio.getEntityManager());
	}
	
	@Test
	public void seleccionarTodasLosComentarios() {
		
	Comentario comentario =	repositorio.findAll().iterator().next();
	 
	 assertEquals("juan", comentario.getAutor());
	}
	

	@Test
	public void seleccionarUnComentario() {
		
		Comentario comentario = repositorio.findOne(1);
		assertEquals("bien!!!", comentario.getTexto());
	}

}
