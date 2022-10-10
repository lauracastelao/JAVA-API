package com.factoriaf5.firstspring.firstspring.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.factoriaf5.firstspring.firstspring.models.Letter;
import com.factoriaf5.firstspring.firstspring.repositories.LetterRepository;

@Service
public class LetterService {
    
    @Autowired
    LetterRepository repository;

    public List<Letter> getAll() {
        return repository.findAll();
    }

    public Letter store(Letter newLetter) {
        return repository.save(newLetter);
    }

    public Map<String,String> delete(Long id) {
        Map<String,String> message = new HashMap<>();

        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            message.put("message", "OK");
            return message;
        }

        message.put("message", "Error");
        return message;
    }

    public Letter update(Long id, Letter newDataLetter) {
        
        return repository.findById(id)
            .map((letter) -> {
                letter.setName(newDataLetter.getName());
               letter.setEmail(newDataLetter.getEmail());
                return repository.save(letter);
            })
            .orElseGet(() -> {
                return repository.save(newDataLetter);
            });

    }

    

}
