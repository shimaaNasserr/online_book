package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
private final UserRepository userRepository;


public UserEntity addUser(UserDto userDto) {
	UserEntity user = new UserEntity();
	user.setName(userDto.getName());
	user.setEmail(userDto.getEmail());
	user.setPassword(userDto.getPassword());
	
	return userRepository.save(user);
}
public UserEntity getUserById(Integer userId){
    return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found with that id :"+ userId));
}    
public List<UserEntity> getAllUsers() {
	return userRepository.findAll();
}
public UserEntity getUserByEmail(String email) {
	return userRepository.findUserByEmail(email).orElse(null);
}
public boolean existByEmail(String email) {
	return userRepository.existByEmail(email);
}
public UserEntity save(UserEntity user) {
	return userRepository.save(user);
}
}
