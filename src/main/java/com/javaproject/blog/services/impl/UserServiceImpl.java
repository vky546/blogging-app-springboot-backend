package com.javaproject.blog.services.impl;
import com.javaproject.blog.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaproject.blog.entities.User;
import com.javaproject.blog.payloads.UserDto;
import com.javaproject.blog.repositories.UserRepo;
import com.javaproject.blog.services.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.userDtoUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToUserDto(savedUser);
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
		
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToUserDto(updatedUser);
		return userDto1;
		
	
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));

		 
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> userDtos =   users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
		
		
		return userDtos;
	}
 
	@Override
	public void deleteUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
		this.userRepo.delete(user);
		
	}
	public User userDtoUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setAbout(userDto.getAbout());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
		return user;
		
	}
	public UserDto userToUserDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
		
	}

	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		//encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		
		
		//roles
		return null;
	}

}
