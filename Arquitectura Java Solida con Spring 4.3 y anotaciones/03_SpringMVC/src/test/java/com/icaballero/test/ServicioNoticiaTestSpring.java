package com.icaballero.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icaballero.bo.Noticia;
import com.icaballero.repositorios.ComentarioRepositorio;
import com.icaballero.repositorios.NoticiaRepositorio;
import com.icaballero.repositorios.jpa.NoticiaRepositoryJPA;
import com.icaballero.servicios.ServicioNoticias;
import com.icaballero.test.config.ConfiguracionSpringTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfiguracionSpringTest.class)
public class ServicioNoticiaTestSpring {

	@Autowired
	NoticiaRepositorio repositorioNoticia;
	@Autowired
	ComentarioRepositorio repositorioComentario;
	@Autowired
	ServicioNoticias servicioNoticias;

	@Test
	public void inyectarRepositorios() {
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
