package com.icaballero.test.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icaballero.bo.Noticia;
import com.icaballero.repositorios.NoticiaRepositorio;
import com.icaballero.test.config.ConfiguracionSpringTest;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfiguracionSpringTest.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class NoticiaRepositoryTestSpring  {
	
	@Autowired
	NoticiaRepositorio repositorio;
	

	@Test
	public void inyectarRepositorio() {
		assertNotNull(repositorio);
	}
	
	@Test
	public void seleccionarTodasLasNoticias() {
		
	 Noticia noticia =	repositorio.findAll().iterator().next();
	 
	 assertEquals("JAVA 9 ha salido", noticia.getTitulo());
	}
	
	@Test
	public void insertarNoticia() {
		
		//em.getTransaction().begin();
		Noticia noticiaNueva = new Noticia("Java 8 streams","Ismael",new Date());
		repositorio.save(noticiaNueva);
		//em.getTransaction().commit();
		
		Noticia noticia = repositorio.findOne("Java 8 streams");
		assertEquals(noticiaNueva, noticia);
		
	}

}
