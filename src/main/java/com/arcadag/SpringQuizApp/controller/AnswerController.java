package com.arcadag.SpringQuizApp.controller;

import com.arcadag.SpringQuizApp.dtos.AnswerDto;
import com.arcadag.SpringQuizApp.dtos.ResultDto;
import com.arcadag.SpringQuizApp.servicies.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/answers")
public class AnswerController {
    private final AnswerService answerService;
    @PostMapping
    public ResultDto getResult(@RequestBody List<AnswerDto> answers) {
       log.info(answers.toString());
       return answerService.checkAnswers(answers);
    }
}
