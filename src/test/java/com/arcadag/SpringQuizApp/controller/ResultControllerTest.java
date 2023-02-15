package com.arcadag.SpringQuizApp.controller;

import com.arcadag.SpringQuizApp.dtos.AnswerDto;
import com.arcadag.SpringQuizApp.dtos.ResultDto;
import com.arcadag.SpringQuizApp.entity.Answer;
import com.arcadag.SpringQuizApp.servicies.QuizService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ResultControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private QuizService quizService;

    @Test
    public void getResultTest() {
        List<AnswerDto> answerDtos = quizService.getQuiz().stream().map(q -> {
            AnswerDto answerDto = new AnswerDto();
            answerDto.setId(q.getId());
            List<String> corAnswers = q.getQuestion().getAnswers().stream()
                    .filter(Answer::isCorrect)
                    .map(Answer::getAnswer)
                    .toList();
            answerDto.setAnswers(corAnswers);
            return answerDto;
        }).toList();

        ResultDto resultDto = webTestClient.post()
                .uri("api/answers")
                .bodyValue(answerDtos)
                .exchange()
                .expectBody(ResultDto.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertNotNull(resultDto);
        Assertions.assertEquals(answerDtos.size(), resultDto.getCorrectAnswers());

    }


}
