package com.icaballero.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.icaballero.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServicesImpl implements UsuarioService {

	private List<Usuario> lista;

	public UsuarioServicesImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1, "Ismael", "Caballero"));
		this.lista.add(new Usuario(2, "Pepe", "Flores"));
		this.lista.add(new Usuario(3, "Juan", "Garcia"));
		this.lista.add(new Usuario(4, "Ana", "Hernandez"));
	}

	@Override
	public List<Usuario> listar() {

		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario usuario = null;

		for (Usuario u : lista) {
			if (u.getId().equals(id)) {
				usuario = u;
				break;
			}

		}

		return usuario;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario =obtenerPorId(id);		
		
		return Optional.ofNullable(usuario);
	}

}
