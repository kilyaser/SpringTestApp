package com.arcadag.SpringQuizApp.domain;

import com.arcadag.SpringQuizApp.dtos.AnswerDto;
import com.arcadag.SpringQuizApp.dtos.ReportDto;
import com.arcadag.SpringQuizApp.dtos.ReportItem;
import com.arcadag.SpringQuizApp.entity.Answer;
import com.arcadag.SpringQuizApp.servicies.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ReportBuilderTest {

    @Autowired
    private ReportBuilder reportBuilder;
    @Autowired
    private QuizService quizService;

    @Value("${quiz.question.quantity}")
    private int quantity;

    @Test
    public void getReportTest() {

        List<AnswerDto> correctAnswers = quizService.getQuiz().stream().map(q -> {
            AnswerDto answerDto = new AnswerDto();
            answerDto.setId(q.getId());
            List<String> corAnswers = q.getQuestion().getAnswers().stream()
                    .filter(Answer::isCorrect)
                    .map(Answer::getAnswer)
                    .toList();
            answerDto.setAnswers(corAnswers);
            return answerDto;
        }).toList();

        List<AnswerDto> incorrectAnswers = quizService.getQuiz().stream().map(q -> {
            AnswerDto answerDto = new AnswerDto();
            answerDto.setId(q.getId());
            answerDto.setAnswers(new ArrayList<>());
            return answerDto;
        }).toList();

        ReportDto reportCorrect = reportBuilder
                .createReport(correctAnswers)
                .addReportItems()
                .build();

        ReportDto reportIncorrect = reportBuilder
                .createReport(incorrectAnswers)
                .addReportItems()
                .build();

        Assertions.assertNotNull(reportCorrect);
        Assertions.assertEquals(0, reportCorrect.getReportItems().size());

        Assertions.assertNotNull(reportIncorrect);
        Assertions.assertEquals(quantity, reportIncorrect.getReportItems().size());

        for (ReportItem reportItem : reportIncorrect.getReportItems()) {
            Assertions.assertEquals("You didn't answer the question.", reportItem.getUserAnswers().get(0));
        }

    }
}
