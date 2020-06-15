package com.icaballero.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;


import org.junit.Test;

import com.icaballero.bo.Noticia;

public class NoticiaTest extends JPAUnitTest{

	
	@Test
	public void entityManagerFactoryOk() {
		
		assertNotNull(emf);
	}
	
	
	@Test
	public void entityManagerOk() {
		
		assertNotNull(em);
	}
	
	@Test
	public void seleccionarNoticiaInicial() {
		
		Noticia noticia = em.find(Noticia.class, "JAVA 9 ha salido");
		assertEquals("Ismael", noticia.getAutor());
	}
	
	@Test
	public void borrarNoticiaInicial() {
		
		Noticia noticia = em.find(Noticia.class, "JAVA 9 ha salido");
		em.getTransaction().begin();
		em.remove(noticia);
		em.getTransaction().commit();
		
		Noticia sinNoticia = em.find(Noticia.class, "JAVA 9 ha salido");
		assertNull(sinNoticia);
	
	}
	
	@Test
	public void insertarNuevaNoticia() {
		
		em.getTransaction().begin();
		Noticia nueva = new Noticia("Java 8 Lambas", "Ismael", new Date());
		em.persist(nueva);
		em.getTransaction().commit();
		
		Noticia noticiaInsertada = em.find(Noticia.class, "Java 8 Lambas");
		assertNotNull(noticiaInsertada);
	
	}
	
	
	
	
	

}
