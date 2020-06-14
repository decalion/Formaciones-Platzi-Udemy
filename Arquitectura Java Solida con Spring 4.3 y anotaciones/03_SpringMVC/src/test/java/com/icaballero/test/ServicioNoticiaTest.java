package com.icaballero.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import com.icaballero.bo.Noticia;
import com.icaballero.repositorios.jpa.ComentarioRepositoryJPA;
import com.icaballero.repositorios.jpa.NoticiaRepositoryJPA;
import com.icaballero.servicios.jpa.ServicioNoticiasJPA;

public class ServicioNoticiaTest {

	
	NoticiaRepositoryJPA repositorioNoticia;
	ComentarioRepositoryJPA repositorioComentario;
	ServicioNoticiasJPA servicioNoticias;
	
	@Before
	public void setUp() {
		
		repositorioNoticia = new NoticiaRepositoryJPA();
		repositorioComentario = new ComentarioRepositoryJPA();
		servicioNoticias = new ServicioNoticiasJPA();
		
		
		
	}
	
	
	@Test
	public void inyectarRepositorios() {
		servicioNoticias.setRepositorioNoticias(repositorioNoticia);
		servicioNoticias.setRepositorioComentarios(repositorioComentario);
		
		assertEquals(repositorioNoticia, servicioNoticias.getRepositorioNoticias());
		assertEquals(repositorioComentario, servicioNoticias.getRepositorioComentarios());
		
		
	}
	
	
	@Test
	public void buscarTodasLasNoticias() {
		
		NoticiaRepositoryJPA miMock = mock(NoticiaRepositoryJPA.class);
		when(miMock.findAll()).thenReturn(Arrays.asList(new Noticia("JAVA 9 ha salido")));
		
		servicioNoticias.setRepositorioNoticias(miMock);
		
		Iterable<Noticia> it = servicioNoticias.findAllNoticia();
		
		Noticia noticia = it.iterator().next();
		
		assertEquals("JAVA 9 ha salido", noticia.getTitulo());
		
		
		
	}
	
	
	
	

}
