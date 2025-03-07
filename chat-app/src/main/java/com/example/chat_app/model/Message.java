package com.example.chat_app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@ManyToOne
	private User user;
	private String content;
	private String response; 
	private LocalDateTime date;
	
	public Message() {
	}
	
	public Message(User user, String content, String response, LocalDateTime date) {
        this.user = user;
        this.content = content;
        this.response = response;
        this.date = date;
    }

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}	
}

