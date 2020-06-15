package com.icaballero.test.spring;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icaballero.bo.Noticia;
import com.icaballero.repositorios.NoticiaRepositorio;
import com.icaballero.test.config.ConfiguracionSpringTest;
import com.icaballero.test.jpa.JPAUnitTest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConfiguracionSpringTest.class)
public class NoticiaRepositoryTest extends JPAUnitTest {
	
	@Autowired
	NoticiaRepositorio repositorio;
	

	
	@Test
	public void seleccionarTodasLasNoticias() {
		
	 Noticia noticia =	repositorio.findAll().iterator().next();
	 
	 assertEquals("JAVA 9 ha salido", noticia.getTitulo());
	}
	
	@Test
	public void insertarNoticia() {
		
		em.getTransaction().begin();
		Noticia noticiaNueva = new Noticia("Java 8 streams","Ismael",new Date());
		repositorio.save(noticiaNueva);
		em.getTransaction().commit();
		
		Noticia noticia = repositorio.findOne("Java 8 streams");
		assertEquals(noticiaNueva, noticia);
		
	}
	
	
	@Test
	public void borrarNoticia() {
		
		em.getTransaction().begin();
		Noticia noticiaNueva = new Noticia("JAVA 9 ha salido");
		repositorio.delete(noticiaNueva);
		em.getTransaction().commit();
		
		Noticia noticia = repositorio.findOne("JAVA 9 ha salido");
		assertEquals(null, noticia);
	}


}
