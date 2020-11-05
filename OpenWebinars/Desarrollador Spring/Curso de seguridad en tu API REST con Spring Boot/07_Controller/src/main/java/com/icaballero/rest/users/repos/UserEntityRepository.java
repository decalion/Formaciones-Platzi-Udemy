package com.icaballero.rest.users.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icaballero.rest.users.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
	
	Optional<UserEntity> findByUsername(String username);

}
