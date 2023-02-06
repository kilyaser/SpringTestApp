package com.arcadag.SpringQuizApp.servicies;

import com.arcadag.SpringQuizApp.models.QuestionItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QuizServiceTest {

    @Autowired
    private QuizService quizService;
    @Value("${quiz.question.quantity}")
    private int quantity;

    @Test
    public void getQuizTest() {
        List<QuestionItem> questions = quizService.getQuiz();
        Assertions.assertNotNull(questions);
        Assertions.assertEquals(quantity, questions.size());
    }
}
