package com.icaballero.rest.users.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.icaballero.rest.service.base.BaseService;
import com.icaballero.rest.users.model.UserEntity;
import com.icaballero.rest.users.model.UserRole;
import com.icaballero.rest.users.repos.UserEntityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository>{


	private final  PasswordEncoder passwordEncoder;

	/**
	 * Nos permite buscar un usuario por su nombre de usuario
	 * @param username
	 * @return 
	 */
	public Optional<UserEntity> findUserByUsername(String username) {
		return this.repositorio.findByUsername(username);
	}
	
	/**
	 * Nos permite crear un nuevo UserEntity con rol USER
	 * @param userEntity
	 * @return
	 */
	public UserEntity nuevoUsuario(UserEntity userEntity) {
		
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		userEntity.setRoles(Stream.of(UserRole.USER).collect(Collectors.toSet()));
		return save(userEntity);
	}
	
	
}
