package com.icaballero.rest.users.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icaballero.rest.users.dto.CreateUserDto;
import com.icaballero.rest.users.dto.GetUserDto;
import com.icaballero.rest.users.dto.UserDtoConverter;
import com.icaballero.rest.users.model.UserEntity;
import com.icaballero.rest.users.services.UserEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController { 
	
	private final UserEntityService userEntityService;
	private final UserDtoConverter userDtoConverter;
	
	
	@PostMapping("/")
	public GetUserDto nuevoUsuario(@RequestBody CreateUserDto newUser) {
			return userDtoConverter.convertUserEntityToGetUserDto(userEntityService.nuevoUsuario(newUser));

	}
	
	
	@GetMapping("/me")
	public GetUserDto yo(@AuthenticationPrincipal UserEntity user) {
		return userDtoConverter.convertUserEntityToGetUserDto(user);
	}

}
