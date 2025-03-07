package com.example.chat_app.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String username;

	@OneToMany
	private List<Message> messages;
	
	public User() {
		
	}
	
	public User(String name) {
		this.username = name;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Message> getMessages() { 
		return this.messages; 
	}
	
	public void addMessages(List<Message> newMessages) {
	    if (this.messages == null) {
	        this.messages = new ArrayList<>();
	    }
	    this.messages.addAll(newMessages);
	}

}
