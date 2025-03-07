package com.example.chat_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.chat_app.model.Message;
import com.example.chat_app.model.User;
import com.example.chat_app.service.ChatService;



@Controller
@RequestMapping("/chat")
public class ChatController {
	 private final ChatService chatService;

	    public ChatController(ChatService chatService) {
	        this.chatService = chatService;
	    }

	    @GetMapping
	    public String showChat(Model model) {
	        model.addAttribute("users", chatService.getAllUsers());
	        
	        return "chattemplate";
	    }

	    @PostMapping("/send")
	    public String sendMessage(@RequestParam String username, @RequestParam String content, Model model) {
	    	if (username.isBlank() || content.isBlank()) {
	            model.addAttribute("error", "Le nom d'utilisateur et le message ne peuvent pas être vides.");
	            return "chattemplate";
	    	}
	    	
	    	Message message = chatService.sendMessage(username, content);
	    	model.addAttribute("lastMessage", message);
	        model.addAttribute("users", chatService.getAllUsers());

	        return "chattemplate";
	    }
	    
	    @GetMapping("/messages")
	    public String showUsersList(Model model) {
	        List<User> users = chatService.getAllUsers();
	        
	        for (User user : users) {
	            List<Message> messages = chatService.getUserMessages(user.getId());
	            user.addMessages(messages);
	        }
	        
	        model.addAttribute("users", users);
	        
	        return "userstemplate";
	    }
}

