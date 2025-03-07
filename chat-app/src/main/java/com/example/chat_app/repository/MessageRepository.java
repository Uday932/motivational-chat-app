package com.example.chat_app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.chat_app.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findByUserId(Integer userId);
}