package com.icaballero.app;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.icaballero.app.services.TokenService;


public class TokenTest {

	@Test
	public void testCrearToken() throws ParseException {
		
		TokenService servicio = new TokenService();
		DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		String token = servicio.crearToken("ismael1", "ismael", formateador.parse("10/08/20201"));
		
		//System.out.println(token);
		
		assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJpc21hZWwxIiwiZXhwIjo1NzUzMzM4Nzc2MDB9.tBiEF7Rgq4IAWdbdSHoQ7wa32YeEokLM57QP3Ak_4CE", token);
	}
	
	@Test
	public void testLeerTokenUsuario() {
		
		TokenService service = new TokenService();
		
		String usuario = service.leeToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJpc21hZWwxIiwiZXhwIjo1NzUzMzM4Nzc2MDB9.tBiEF7Rgq4IAWdbdSHoQ7wa32YeEokLM57QP3Ak_4CE", "ismael");
		
		assertEquals("ismael1", usuario);
	}
	
}
