package com.icaballero.app.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icaballero.app.mappings.Usuario;
import com.icaballero.app.services.HttpParseService;

public class FiltroLogin extends AbstractAuthenticationProcessingFilter {

	private HttpParseService httpParseService;

	public FiltroLogin(String url, AuthenticationManager manager) {
		super(url);

		httpParseService = new HttpParseService();
		setAuthenticationManager(manager);

	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		// Lee el usuario y la clave de una peticion post y los mapea en una clase java
		Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
		// Generamos un token de Spring security
		UsernamePasswordAuthenticationToken usuarioSpring = new UsernamePasswordAuthenticationToken(usuario.getNombre(),
				usuario.getPassword());

		return getAuthenticationManager().authenticate(usuarioSpring);

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		// Obtener nombre del usuario
		String nombreUsuario= authResult.getName();

		// Creamos el JWT
		httpParseService.crearToken(response, nombreUsuario);

	}

}
