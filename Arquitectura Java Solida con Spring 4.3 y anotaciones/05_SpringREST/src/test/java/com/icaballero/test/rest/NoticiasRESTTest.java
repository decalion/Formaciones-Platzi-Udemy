package com.icaballero.test.rest;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.icaballero.bo.Noticia;

import io.restassured.RestAssured;


//Importes estaticos para uso de Rest Assured
import static io.restassured.RestAssured.when;
import static io.restassured.http.Method.GET;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Persistence;

public class NoticiasRESTTest {
	
	
	@Before
	public  void setupStatic() {
		Persistence.generateSchema("arquitectura", null);
		
	}
	
	
	@BeforeClass
	public static void setUp() {
		//Configurar assured rest
		RestAssured.port=8080;
		RestAssured.baseURI="http://localhost";
		RestAssured.basePath="/web/webapi";
		
		
	}
	
	@Test
	public void obtenerNoticiasGet() {
		
		//Cuando pidas la url noticia comprueba que el cuerpo contiene JAVA 9 ha salido
		when().request(GET,"/noticias")
		.then()
		.body(containsString("JAVA 9 ha salido"));
		
		
	}
	
	
	@Test
	public void obtenerUnaNoticias() {
		
		//Cuando pidas la url noticia comprueba que el cuerpo contiene JAVA 9 ha salido
		when().request(GET,"/noticias/JAVA 9 ha salido")
		.then()
		.body("titulo",equalTo("JAVA 9 ha salido"));
		
		
	}
	
	@Test
	public void insertarNoticiaPOST() throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formato.parse("25/07/2020");
		Noticia noticia = new Noticia("java 8 streams","ismael",fecha);
		
		//Insertar una nueva noticia en json
		given()
		.contentType("application/json")
		.body(noticia)
		.when()
		.post("/noticias")
		.then()
		.statusCode(200); // 200 es igual a OK
		
	}
	
	@Test
	public void actualizarNoticiaPUT() throws ParseException {
		
		
		//nueva noticia que sera la que actualice la noticia principal
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/YYYY");
		Date fecha= formato.parse("25/01/2018");
		Noticia noticia= new Noticia("JAVA 9 ha salido","pedro",fecha);
		
		//dado un objeto json de noticia cuando realicemos un post nos devuelve ok
		given().contentType("application/json")
		.body(noticia).when()
		.put("/noticias/JAVA 9 ha salido")
		.then().statusCode(200);
		
	}
	
	
	
	@Test
	public void borrarNoticiaDELETE() {
		
		when()
		.delete("/noticias/JAVA 9 ha salido")
		.then().statusCode(200);
	
	}
	

}
