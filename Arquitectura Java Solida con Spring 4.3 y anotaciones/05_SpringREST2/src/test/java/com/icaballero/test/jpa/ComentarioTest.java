package com.icaballero.test.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;

import com.icaballero.bo.Comentario;
import com.icaballero.bo.Noticia;


public class ComentarioTest extends JPAUnitTest {
	

	
	@Test
	public void entityManagerFactoryOk() {
		
		assertNotNull(emf);
	}
	
	
	@Test
	public void entityManagerOk() {
		
		assertNotNull(em);
	}
	
	@Test
	public void seleccionarComentarioInicial() {
		
		Comentario comentario = em.find(Comentario.class, 1);
		assertEquals("juan", comentario.getAutor());
	}
	
	@Test
	public void seleccionarComentarioInicialConsulta() {
		
		int total = em.createQuery("Select c from Comentario c").getResultList().size();
		assertEquals(1, total);
	}
	
	
	
	@Test
	public void SeleccionarComentarioDeNoticia() {
		
		Noticia noticia = em.find(Noticia.class, "JAVA 9 ha salido");
		Comentario comentario = noticia.getComentarios().get(0);
		assertEquals("juan", comentario.getAutor());
	}

}
