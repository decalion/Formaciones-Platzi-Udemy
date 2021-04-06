package com.icaballero.orderapi.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.icaballero.orderapi.entity.User;
import com.icaballero.orderapi.exceptions.NoDataFoundException;
import com.icaballero.orderapi.repository.UserRepository;
import com.icaballero.orderapi.service.impl.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * Filtro para validar el token y registrar el usuario en spring security
 * 
 * @author Ismael Caballero
 *
 */
@Slf4j
public class TokenAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			
			String jwt = getJwtFromRequest(request);

			if (StringUtils.hasText(jwt) && userService.validateToken(jwt)) {

				String username = userService.getUsernameFromToken(jwt);

				User user = userRepo.findByUsername(username)
						.orElseThrow(() -> new NoDataFoundException("No existe el usuario"));

				// Registrar el usuario en spring security

				UserPrincipal principal = UserPrincipal.create(user);

				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal,
						null, principal.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				// Se registra en el context de seguridad
				SecurityContextHolder.getContext().setAuthentication(authentication);

			}
		} catch (Exception e) {
			log.error("Error al autenticar el usuario");
		}
		
		filterChain.doFilter(request, response);
	}

	/**
	 * Obtener el token del Header
	 * @param request
	 * @return
	 */
	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
			
			return bearerToken.substring(7,bearerToken.length());
		}
		
		
		return null;
	}

}
