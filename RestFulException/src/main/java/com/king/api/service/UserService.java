package com.king.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.king.api.exception.UserNotFoundException;
import com.king.api.model.User;
import com.king.api.model.UserRequest;
import com.king.api.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;

	public User saveUser(UserRequest userRequest) {
		
		User user=User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile()
				,userRequest.getGender(), userRequest.getAge(), userRequest.getNatonality());
		return userRepo.save(user);
	}
	
	public List<User> getAllUser(){
		
		return userRepo.findAll();
	}
	
	public User GetUserById(int id) throws UserNotFoundException {
		User user=userRepo.findByUserId(id);
		if (user!=null) {
			return user;
		} else {
			throw new UserNotFoundException("User not foud for ID: "+id);
		}
	}

}
