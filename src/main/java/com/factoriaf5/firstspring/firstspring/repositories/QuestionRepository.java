package com.factoriaf5.firstspring.firstspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factoriaf5.firstspring.firstspring.models.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    
}
