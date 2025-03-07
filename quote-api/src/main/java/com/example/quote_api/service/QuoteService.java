package com.example.quote_api.service;

import com.example.quote_api.model.Quote;
import com.example.quote_api.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {
	
    private QuoteRepository quoteRepository;
    
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        Random random = new Random();
        return quotes.get(random.nextInt(quotes.size()));
    }
}
