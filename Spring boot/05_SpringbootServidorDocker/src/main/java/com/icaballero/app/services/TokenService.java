package com.icaballero.app.services;

import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class TokenService {
	
	
	
	/**
	 * Funcion para crear el JSON WEB TOKEN
	 * @param usuario
	 * @param claveEncryptar
	 * @param expiracion
	 * @return
	 */
	public String crearToken(String usuario,String claveEncryptar, Date expiracion) {
		
		String JWT = Jwts.builder()
		         .setSubject(usuario)
		         .setExpiration(expiracion)
		         //es la parte en la cual nosotros definimos la clave de encriptacion y el algoritmo para generar el hash
		         .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString((claveEncryptar.getBytes())))
		         //generando el hash completo
		         .compact();
			
			return JWT;
	}

	
	
	/**
	 * Funcion para leer el token y obtener el usuario
	 * @param tokenReal token real generado desde la funcion crearToken
	 * @param claveEncriptada
	 * @return
	 */
	public String leeToken(String tokenReal, String claveEncriptada) {
		
		String usuario = Jwts.parser()
			     .setSigningKey( Base64.getEncoder().encodeToString((claveEncriptada.getBytes())))
			     .parseClaimsJws(tokenReal)
			     .getBody()
			     .getSubject();
			return usuario;
		
	}
	
	
}
