package com.icaballero.orderapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icaballero.orderapi.converters.UserConverter;
import com.icaballero.orderapi.dtos.LoginRequestDTO;
import com.icaballero.orderapi.dtos.LoginResponseDTO;
import com.icaballero.orderapi.dtos.SignupRequestDTO;
import com.icaballero.orderapi.dtos.UserDTO;
import com.icaballero.orderapi.entity.User;
import com.icaballero.orderapi.service.impl.UserService;
import com.icaballero.orderapi.utils.WrapperResponse;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserConverter converter;
	
	
	@PostMapping(value = "/singup")
	public ResponseEntity<WrapperResponse<UserDTO>> signup(@RequestBody SignupRequestDTO request) {
		
		User user = userService.createUser(converter.singup(request));
		
		return new WrapperResponse<UserDTO>(true, "succes", converter.fromEntity(user))
				.createResponse(HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/login")
	public ResponseEntity<WrapperResponse<LoginResponseDTO>> login(@RequestBody LoginRequestDTO request) {
		
		LoginResponseDTO response = userService.login(request);
		
		return new WrapperResponse<LoginResponseDTO>(true, "succes", response)
				.createResponse(HttpStatus.OK);
	}

}
