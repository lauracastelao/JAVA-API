package com.factoriaf5.firstspring.firstspring.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.factoriaf5.firstspring.firstspring.models.Question;
import com.factoriaf5.firstspring.firstspring.repositories.QuestionRepository;

@Service
public class QuestionService {
    
    @Autowired
    QuestionRepository repository;

    public List<Question> getAll() {
        return repository.findAll();
    }

    public Question store(Question newQuestion) {
        return repository.save(newQuestion);
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

    public Question update(Long id, Question newDataQuestion) {
        
        return repository.findById(id)
            .map((question) -> {
                question.setPregunta(newDataQuestion.getPregunta());
                question.setRespuesta(newDataQuestion.getRespuesta());
             
                return repository.save(question);
            })
            .orElseGet(() -> {
               return repository.save(newDataQuestion);

            });

    }

    

}
