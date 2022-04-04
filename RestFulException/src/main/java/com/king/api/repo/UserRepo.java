package com.king.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.king.api.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	
	 User findByUserId(int id);
}
