package com.example.chat_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.chat_app.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username); 
}
