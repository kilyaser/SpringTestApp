package com.arcadag.SpringQuizApp.controller;

import com.arcadag.SpringQuizApp.dtos.QuestionItemDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class QuizControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @Value("${quiz.question.quantity}")
    private int quantity;

    @Test
    public void getQuizControllerTest() {
        List<QuestionItemDto> itemDtosByHttp = webTestClient.get()
                .uri("/api/quiz")
                .exchange()
                .expectBodyList(QuestionItemDto.class)
                .returnResult().
                getResponseBody();

        Assertions.assertNotNull(itemDtosByHttp);
        Assertions.assertEquals(quantity, itemDtosByHttp.size());
        Assertions.assertNotNull(itemDtosByHttp.get(0).getQuestion());

    }
}
