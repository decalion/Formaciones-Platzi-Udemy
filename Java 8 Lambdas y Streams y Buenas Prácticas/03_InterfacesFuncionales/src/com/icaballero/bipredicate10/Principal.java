package com.icaballero.bipredicate10;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import com.icaballero.consumer01.Persona;
import com.icaballero.consumer01.ServicioPersona;
import com.icaballero.defaultmethod09.Documento;


public class Principal {

	public static void main(String[] args) {

		Documento d1 = new Documento("java", 1);
		Documento d2 = new Documento("net", 2);
		Documento d3 = new Documento("python", 3);
		Documento d4 = new Documento("java", 4);
		
		List<Documento> list= Arrays.asList(d1,d2,d3,d4);
		
	List<Documento> listaNueva = filtrar(list,Principal::mayorQue,d3);
	
	listaNueva.stream().map(Documento::getTitulo).forEach(System.out::println);

		}
	
	
	public static List<Documento> filtrar(List<Documento> lista,
			BiPredicate<Documento,Documento> predicado, Documento comparar){
		
		return lista.stream().
				filter( (doc)-> predicado.test(doc, comparar)).
				collect(Collectors.toList());

	}
	
	//BiPredicate
	//Recibe 2 parametros y devuelve verdadero o falso
	public static  boolean mayorQue(Documento inicial, Documento comparar) {
		
		if(inicial.getVersion() > comparar.getVersion()) {
			
			return true;
		}else {
			
			return false;
		}
	}
	
	


}
