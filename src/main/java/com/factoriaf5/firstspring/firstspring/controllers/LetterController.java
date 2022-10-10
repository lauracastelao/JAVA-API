package com.factoriaf5.firstspring.firstspring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factoriaf5.firstspring.firstspring.services.LetterService;
import com.factoriaf5.firstspring.firstspring.models.Letter;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/")
public class LetterController {
    
    @Autowired // Inyección de dependencia
    LetterService letterService;

    @GetMapping(value="/letters")
    public List<Letter> getAll() {
        return letterService.getAll();
    }

    @PostMapping(value="/letters")
    public Letter store(@RequestBody Letter newLetter) {
        return letterService.store(newLetter);
    }

    @DeleteMapping(path = "/letters/{id}")
    public Map<String,String> deleteLetter(@PathVariable Long id) {
        return letterService.delete(id);
    }

    @PutMapping(path = "/letters/{id}")
    public Letter updateLetter(@PathVariable Long id, @RequestBody Letter letter) {
        return letterService.update(id, letter);
    }





    
    

}
