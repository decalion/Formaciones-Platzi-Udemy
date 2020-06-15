package com.icaballero.test.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icaballero.bo.Comentario;
import com.icaballero.repositorios.ComentarioRepositorio;
import com.icaballero.test.config.ConfiguracionSpringTest;
import com.icaballero.test.jpa.JPAUnitTest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConfiguracionSpringTest.class)
public class ComentarioRepositoryTest extends JPAUnitTest {
	
	@Autowired
	ComentarioRepositorio repositorio;
	

	
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
