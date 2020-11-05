package com.icaballero.rest.users.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.icaballero.rest.service.base.BaseService;
import com.icaballero.rest.users.model.UserEntity;
import com.icaballero.rest.users.repos.UserEntityRepository;

@Service
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository>{

	
	public Optional<UserEntity> findUserByUsername(String username) {
		return this.repositorio.findByUsername(username);
	}
	
	
}
