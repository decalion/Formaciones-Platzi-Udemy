package com.icaballero.servicios;

import java.util.ArrayList;
import java.util.List;

import com.icaballero.negocio.Curso;



public class ServiciosCurso {

	private static List<Curso> listaCursos = new ArrayList<Curso>();

	static {
		Curso c1 = new Curso("Java", 1);
		Curso c2 = new Curso("NET", 1);
		Curso c3 = new Curso("PHP", 2);
		listaCursos.add(c1);
		listaCursos.add(c2);
		listaCursos.add(c3);
	}

	
	public Curso buscarUno(String nombre) {
		
		for (Curso c : listaCursos) {
			
			if(c.getNombre().equals(nombre)) {
				return c;
			}
		}
		
		
		return null;
	}
	
	public List<Curso> buscarTodo() {

		return listaCursos;

	}
	
	
	public void add(Curso c) {
		listaCursos.add(c);
	}
	
	
	public void borrar(Curso c) {
		listaCursos.remove(c);
	}
	

}
