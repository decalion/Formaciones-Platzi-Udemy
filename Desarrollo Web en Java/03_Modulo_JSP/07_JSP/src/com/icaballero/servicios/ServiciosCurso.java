package com.icaballero.servicios;

import java.util.ArrayList;
import java.util.List;

import com.icaballero.clases.Curso;

public class ServiciosCurso {
	
	
	public List<Curso> buscarTodo(){
		
		Curso c1 = new Curso("Java",1);
		Curso c2 = new Curso("NET",1);
		Curso c3 = new Curso("PHP",2);
		
		List<Curso> listaCursos = new ArrayList<Curso>();
		listaCursos.add(c1);
		listaCursos.add(c2);
		listaCursos.add(c3);
		
		return listaCursos;
		
	}

}
