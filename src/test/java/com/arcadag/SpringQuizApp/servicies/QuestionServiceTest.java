package com.arcadag.SpringQuizApp.servicies;

import com.arcadag.SpringQuizApp.entity.Question;
import com.arcadag.SpringQuizApp.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @Test
    public void countQuestionTest() {
        long count = questionService.countQuestions();
        Assertions.assertTrue(count > 0);
    }

    @Test
    public void findQuestionByIdTest() {
        long count = questionService.countQuestions();
        Question question = questionService.findQuestionById(count);

        Assertions.assertNotNull(question);
        Assertions.assertEquals(4, question.getAnswers().size());

        Assertions.assertThrowsExactly(ResourceNotFoundException.class, () -> questionService.findQuestionById(count + 1));



    }



}
