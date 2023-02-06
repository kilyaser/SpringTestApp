package com.arcadag.SpringQuizApp.controller;

import com.arcadag.SpringQuizApp.converters.QuestionItemConverter;
import com.arcadag.SpringQuizApp.dtos.QuestionItemDto;
import com.arcadag.SpringQuizApp.servicies.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class QuizController {
    private final QuizService quizService;
    private final QuestionItemConverter  questionItemConverter;


    @GetMapping("/quiz")
    public List<QuestionItemDto> getQuiz() {
       return questionItemConverter.toQuestionItemDto(quizService.getQuiz());
    }


}
