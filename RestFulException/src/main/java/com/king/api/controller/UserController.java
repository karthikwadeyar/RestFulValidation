package com.king.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.king.api.exception.UserNotFoundException;
import com.king.api.model.User;
import com.king.api.model.UserRequest;
import com.king.api.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("signup")
	public ResponseEntity<User> signUpUser(@RequestBody @Valid UserRequest  userRequest){
		
		return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> GetUserById(@PathVariable int id) throws UserNotFoundException{
		
		return new ResponseEntity<User>(userService.GetUserById(id),HttpStatus.ACCEPTED);
	}

}
