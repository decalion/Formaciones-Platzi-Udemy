package com.icaballero.app.services;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import com.icaballero.app.mappings.UsuarioAutentificado;


public class HttpParseService {
	
	
	private final long EXPIRATION= 3600000; // 1 hora
	private final String PASSWORD = "ismael";
	private final String BEARER ="Bearer"; //prefijo token
	private final String AUTHORIZATION ="Authorization"; //Cabezera http
	

	//private TokenService tokenService;
	
	public void crearToken(HttpServletResponse response,String usuario) {
		
		String JWT = new TokenService().crearToken(usuario,PASSWORD,new Date (System.currentTimeMillis()+EXPIRATION));
		
		
		response.addHeader(AUTHORIZATION, BEARER + " " + JWT);
		

	}
	
	public Authentication leeToken(HttpServletRequest request) {
		
	
		
		String token = request.getHeader(AUTHORIZATION);
		
		
		if(token!=null) {
			
			//Obtenemos el hash completo del token
			String tokenReal=token.substring(token.indexOf(" ")+1);
			
			String usuario = new TokenService().leeToken(tokenReal, PASSWORD);
			
			if(usuario!=null) {
				
				//Hay que devolver un objeto de Spring security
			
					return new UsuarioAutentificado(usuario);
			}
		}
		
		
		return null;
		
	}
	

}
