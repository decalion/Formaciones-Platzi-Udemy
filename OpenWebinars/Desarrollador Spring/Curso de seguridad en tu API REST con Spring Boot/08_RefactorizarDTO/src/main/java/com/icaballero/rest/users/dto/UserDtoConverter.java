package com.icaballero.rest.users.dto;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.icaballero.rest.users.model.UserEntity;
import com.icaballero.rest.users.model.UserRole;

@Component
public class UserDtoConverter {
	
	public GetUserDto convertUserEntityToGetUserDto(UserEntity user) {
		return GetUserDto.builder()
				.username(user.getUsername())
				.avatar(user.getAvatar())
				.roles(user.getRoles().stream()
							.map(UserRole::name)
							.collect(Collectors.toSet())
				).build();
	}

}
