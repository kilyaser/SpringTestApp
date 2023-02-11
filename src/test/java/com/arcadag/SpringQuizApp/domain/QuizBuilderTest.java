package com.arcadag.SpringQuizApp.domain;

import com.arcadag.SpringQuizApp.models.Quiz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuizBuilderTest {

    @Autowired
    private QuizBuilder quizBuilder;

    @Value("${quiz.question.quantity}")
    private int quantity;

    @Test
    public void creatQuizTest() {
       Quiz quiz = quizBuilder.createQuiz()
                .addQuestions()
                .build();

        Assertions.assertNotNull(quiz.getQuizData());
        Assertions.assertEquals(quantity, quiz.getQuizData().size());
    }

}
