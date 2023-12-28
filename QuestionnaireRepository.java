package com.example.questionApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


//import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.questionApp.model.Questionnaire;

public interface QuestionnaireRepository extends MongoRepository<Questionnaire, String> {
    // Custom queries can be added here if needed
}
