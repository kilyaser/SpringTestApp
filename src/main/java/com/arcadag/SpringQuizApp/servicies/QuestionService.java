package com.arcadag.SpringQuizApp.servicies;

import com.arcadag.SpringQuizApp.entities.Question;
import com.arcadag.SpringQuizApp.exception.ResourceNotFoundException;
import com.arcadag.SpringQuizApp.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;


    public long countQuestions() {
       return questionRepository.count();
    }
    public Question findQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question isn't found"));
    }



}
