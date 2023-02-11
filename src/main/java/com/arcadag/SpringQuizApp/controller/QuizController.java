package com.arcadag.SpringQuizApp.controller;

import com.arcadag.SpringQuizApp.converters.QuestionItemConverter;
import com.arcadag.SpringQuizApp.dtos.QuestionItemDto;
import com.arcadag.SpringQuizApp.servicies.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class QuizController {
    private final QuizService quizService;
    private final QuestionItemConverter  questionItemConverter;
    @GetMapping("/quiz")
    public ResponseEntity<Iterable<QuestionItemDto>> getQuiz() {
       return ResponseEntity.of(Optional.ofNullable(questionItemConverter.toQuestionItemDto(quizService.getQuiz())));
    }

}
