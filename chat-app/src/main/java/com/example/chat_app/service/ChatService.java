package com.example.chat_app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.chat_app.model.Message;
import com.example.chat_app.model.User;
import com.example.chat_app.repository.MessageRepository;
import com.example.chat_app.repository.UserRepository;


@Service
public class ChatService {
	private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final RestTemplate restTemplate;
    private final String apiUrl = "http://localhost:8081/getQuote";
    
   
    public ChatService(UserRepository userRepository, MessageRepository messageRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.restTemplate = restTemplate;
    }

    public User createUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            user = new User(username);
            userRepository.save(user);
        }
        return user;
    }

    public Message sendMessage(String username, String content) {
    	User user = userRepository.findByUsername(username);
    	if (user == null) {
    	    user = new User(username);
    	    user = userRepository.save(user);
    	}
    	
        Map<String, String> response = restTemplate.getForObject(apiUrl, Map.class);
        

        String quoteMessage = response != null ? response.get("message") : "Aucune citation disponible";

        
        Message message = new Message(user, content, quoteMessage, LocalDateTime.now());
        
        return messageRepository.save(message);
    }

    public List<Message> getUserMessages(Integer userId) {
        return messageRepository.findByUserId(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }
}