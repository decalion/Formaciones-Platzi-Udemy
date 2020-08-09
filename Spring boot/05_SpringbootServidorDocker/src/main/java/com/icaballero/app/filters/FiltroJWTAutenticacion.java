package com.icaballero.app.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.icaballero.app.services.HttpParseService;

public class FiltroJWTAutenticacion extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		//Recibimos el token jwt del request
		  Authentication authentication = new HttpParseService().leeToken((HttpServletRequest)request);
		
		  //Asigna el token de autenticacion que hemos validado con nuestro servicio httparse
		
		  SecurityContextHolder.getContext().setAuthentication(authentication);
		  chain.doFilter(request,response);

		

		
	}

}
