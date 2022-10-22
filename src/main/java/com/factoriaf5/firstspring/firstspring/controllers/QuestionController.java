package com.factoriaf5.firstspring.firstspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factoriaf5.firstspring.firstspring.models.Question;
import com.factoriaf5.firstspring.firstspring.services.QuestionService;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin (origins = "*") 
@RequestMapping(path = "/api/")

public class QuestionController {
  @Autowired  
  QuestionService questionService;

@GetMapping(value = "/questions")
public List<Question> getAll(){
    return questionService.getAll();
}

@PostMapping(value = "/questions")
public Question store(@RequestBody Question newQuestion){
    return questionService.store(newQuestion);
}

@DeleteMapping(path = "/questions/{id}")
public Map<String,String> deleteQuestion(@PathVariable Long id){ 
return questionService.delete(id);
}

@PutMapping(path = "/questions/{id}")
public Question updateQuestion(@PathVariable Long id, @RequestBody Question question){
    return questionService.update(id, question);
}



}
