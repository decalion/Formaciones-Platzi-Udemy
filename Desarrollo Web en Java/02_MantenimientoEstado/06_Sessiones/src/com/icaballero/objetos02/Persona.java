package com.icaballero.objetos02;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	
	
	private String nombre;
	
	private List<String> cursos = new ArrayList<String>();

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void addCurso(String curso) {
		cursos.add(curso);
	}
	
	public void remove(String curso) {
		cursos.remove(curso);
	}

	public List<String> getCursos() {
		return cursos;
	}

	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}

}
