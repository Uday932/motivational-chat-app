package com.example.quote_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    
    // Getters and Setters

	public Quote() {
		
	}
	
	public Quote(String txt) {
		this.text = txt;
	}
	
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
