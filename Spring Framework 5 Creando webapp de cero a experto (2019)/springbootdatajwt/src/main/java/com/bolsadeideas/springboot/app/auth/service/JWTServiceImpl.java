package com.bolsadeideas.springboot.app.auth.service;

import java.io.IOException;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;


import com.bolsadeideas.springboot.app.auth.SimpleGrantedAuthorityMixn;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTServiceImpl implements JWTService {
	
	
	//Generar la clave secreta para el token
	public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	// Multiplicamos por 4 para que dure 4 horas
	public static final long EXPIRATION_DATE = 3600000 * 4;
	
	public static String TOKEN_PREFIX= "Bearer ";
	
	public static final String HEADER_STRING = "Authorization";
	
	

	/**
	 * Metodo para crear el token
	 * 
	 * @throws JsonProcessingException
	 */
	@Override
	public String create(Authentication auth) throws JsonProcessingException {
		
		// Obtener el usuer a travez del objeto Principal casteandolo a User
		String username = ((User) auth.getPrincipal()).getUsername();

		
		Collection<? extends GrantedAuthority> roles = auth.getAuthorities();

		Claims claims = Jwts.claims();
		claims.put("authorities", new ObjectMapper().writeValueAsString(roles));

		
		//Generamos el token con la clave secreta, los roles, el usurio y el tiempo de expiracion
		String token = Jwts.builder().setClaims(claims).setSubject(username)
				.signWith(SECRET_KEY).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE)).compact();

		return token;
	}

	/**
	 * Metodo para validar el token
	 */
	@Override
	public boolean validate(String token) {

		try {
			getClaims(token);

			return true;

		} catch (JwtException | IllegalArgumentException e) {
			e.printStackTrace();

			return false;
		}

	}

	/**
	 * Metodo para obtener los claims
	 */
	@Override
	public Claims getClaims(String token) {

		Claims claims = Jwts.parser()
				// Necesitamos la clave privada
				.setSigningKey(SECRET_KEY)
				// Hay que quitar el Barer para obtener los datos del token
				.parseClaimsJws(resolve(token)).getBody();

		return claims;
	}

	/**
	 * Metodo para obtener el username
	 */
	@Override
	public String getUsername(String token) {

		return getClaims(token).getSubject();
	}

	/**
	 * Metodo para obtener los roles del usuario
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@Override
	public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException {

		Object roles = getClaims(token).get("authorities");

		// Los roles estan en Json y hay quee convertirlos en objetos authority
		Collection<? extends GrantedAuthority> authorities = Arrays
				.asList(new ObjectMapper().addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixn.class)
						.readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class));

		return authorities;
	}

	/**
	 * Metodo para quitar el BNarer y dejar solo la clave
	 */
	@Override
	public String resolve(String token) {
		if (token != null && token.startsWith(TOKEN_PREFIX)) {
			// Hay que quitar el Barer para obtener los datos del token
			return token.replace(TOKEN_PREFIX, "");
		} else {
			return null;
		}
	}

}
