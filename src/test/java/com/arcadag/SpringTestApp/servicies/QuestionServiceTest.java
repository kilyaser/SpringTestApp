package com.arcadag.SpringTestApp.servicies;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuestionServiceTest {

    @Autowired
    QuestionService questionService;

    @Test
    void countQuestionTest() {
        long count = questionService.countQuestions();
        Assertions.assertEquals(12L, count);

    }

}
