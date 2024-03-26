package com.example.demo.service;

import java.util.Collections;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final UserService userService;
	private final RoleService roleService;
	private final PasswordEncoder passwordEncoder;
	
	
public UserEntity register(RegisterRequestDto registerRequestDto) {
	if(userService.existByEmail(registerRequestDto.getEmail())) {
		//
	}
	if(registerRequestDto.getPassword() != registerRequestDto.getConfirmPassword()) {
		//dont matches
	}
	UserEntity user = new UserEntity();
	Role role = roleService.findByName("USER");
	user.setName(registerRequestDto.getName());
	user.setEmail(registerRequestDto.getEmail());
	user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
	user.setRoles(Collections.singletonList(role));
	return userService.save(user);
}


}
