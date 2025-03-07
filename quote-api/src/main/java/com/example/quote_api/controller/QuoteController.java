package com.example.quote_api.controller;

import com.example.quote_api.model.Quote;
import com.example.quote_api.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuoteController {
	
	 QuoteService quoteService;
	 
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/getQuotes")
    public Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }
}
