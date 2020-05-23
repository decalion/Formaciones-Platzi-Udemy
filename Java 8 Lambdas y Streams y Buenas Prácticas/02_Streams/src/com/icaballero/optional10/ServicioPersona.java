package com.icaballero.optional10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.icaballero.stream01.Persona;

public class ServicioPersona {

	static ArrayList<Persona> listaPersona = new ArrayList<Persona>();

	static {
		listaPersona.add(new Persona("pedro", "gomez", 30));
		listaPersona.add(new Persona("ana", "sancherz", 50));
		listaPersona.add(new Persona("gema", "blanco", 20));
		listaPersona.add(new Persona("david", "alvarez", 70));
	}

	public List<Persona> buscarTodos() {

		return listaPersona;

	}

//	public Optional<Persona> buscaPorNombre(String nombre) {
//
//		Optional<Persona> nueva = Optional.empty();
//
//		for (Persona p : listaPersona) {
//
//			if (p.getNombre().equals(nombre)) {
//				nueva = Optional.of(p);
//			}
//
//		}
//
//		return nueva;
//
//	}

	public Optional<Persona> buscaPorNombre(String nombre) {

		return listaPersona.stream()
				.filter((p) -> p.getNombre().equals(nombre))
				.findFirst();

	}

	public List<Persona> buscarTodosJubilados() {

		List<Persona> listaPersona = buscarTodos();

		Stream<Persona> miStream = listaPersona.stream().filter(Persona::estaJubilado);

		return miStream.collect(Collectors.toList());

	}

}
