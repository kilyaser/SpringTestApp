package com.arcadag.SpringQuizApp.controller;

import com.arcadag.SpringQuizApp.dtos.AnswerDto;
import com.arcadag.SpringQuizApp.dtos.ReportDto;
import com.arcadag.SpringQuizApp.dtos.ReportItem;
import com.arcadag.SpringQuizApp.servicies.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Slf4j
public class ReportControllerTest {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private QuizService quizService;
    @Value("${quiz.question.quantity}")
    private int quantity;

    @Test
    public void getReportTest() {
        List<AnswerDto> answerDtos = quizService.getQuiz().stream().map(q -> {
                AnswerDto answerDto = new AnswerDto();
                answerDto.setId(q.getId());
                answerDto.setAnswers(new ArrayList<>());
                return answerDto;
        }).toList();

        ReportDto reportDto = webTestClient.post()
                .uri("/api/report")
                .bodyValue(answerDtos)
                .exchange()
                .expectBody(ReportDto.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertNotNull(reportDto);
        Assertions.assertEquals(quantity, reportDto.getReportItems().size());
        for (ReportItem reportItem : reportDto.getReportItems()) {
            Assertions.assertEquals("You didn't answer the question.", reportItem.getUserAnswers().get(0));
        }
    }
}
