package com.kpvala.userrestapi.controller;

import com.kpvala.userrestapi.dto.UserDto;
import com.kpvala.userrestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	//Add User REST API
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto savedUser = userService.createUser(userDto);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}


	//Get User REST API
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
		UserDto userdto = userService.getUser(userId);
		return ResponseEntity.ok(userdto);
	}

	//Get All Users REST API
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}

	//Update User REST API
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto updatedUserDto) {
		UserDto updatedUser = userService.updateUser(userId, updatedUserDto);
		return ResponseEntity.ok(updatedUser);
	}

	//Delete User REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
		userService.deleteUser(userId);
		return ResponseEntity.ok("User has been deleted");
	}
}
