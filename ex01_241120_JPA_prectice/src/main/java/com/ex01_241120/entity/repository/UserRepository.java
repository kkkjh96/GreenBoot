package com.ex01_241120.entity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex01_241120.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	 Optional<User> findByIdAndPw(String id, String pw);
	 
	 
}
