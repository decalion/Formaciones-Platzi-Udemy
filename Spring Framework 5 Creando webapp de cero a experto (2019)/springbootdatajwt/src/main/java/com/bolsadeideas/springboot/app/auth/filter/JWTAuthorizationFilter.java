package com.bolsadeideas.springboot.app.auth.filter;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.bolsadeideas.springboot.app.auth.service.JWTService;
import com.bolsadeideas.springboot.app.auth.service.JWTServiceImpl;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	private JWTService jwtService;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTService jwtService) {
		super(authenticationManager);

		this.jwtService = jwtService;

	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// Obtenemos el token
		String header = request.getHeader(JWTServiceImpl.HEADER_STRING);

		if (!requiresAuthentication(header)) {
			chain.doFilter(request, response);
			return;
		}

		UsernamePasswordAuthenticationToken authentication = null;

		// Validamos los datos del token
		if (jwtService.validate(header)) {

			authentication = new UsernamePasswordAuthenticationToken(jwtService.getUsername(header), null,
					jwtService.getRoles(header));
		}

		// Se encarga de manejar el contexto de seguridad
		SecurityContextHolder.getContext().setAuthentication(authentication);

		chain.doFilter(request, response);

	}

	protected boolean requiresAuthentication(String header) {

		// Si es nulo o no comienza por Barer devulve false
		if (header == null || !header.startsWith(JWTServiceImpl.TOKEN_PREFIX)) {

			return false;
		}

		return true;

	}

}
