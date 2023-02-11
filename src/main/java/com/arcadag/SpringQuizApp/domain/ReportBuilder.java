package com.arcadag.SpringQuizApp.domain;

import com.arcadag.SpringQuizApp.dtos.AnswerDto;
import com.arcadag.SpringQuizApp.dtos.ReportDto;
import com.arcadag.SpringQuizApp.dtos.ReportItem;
import com.arcadag.SpringQuizApp.entity.Answer;
import com.arcadag.SpringQuizApp.entity.Question;
import com.arcadag.SpringQuizApp.servicies.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReportBuilder {
    private final QuestionService questionService;
    private ReportDto reportDto;
    private List<AnswerDto> answerDtos;


    public ReportBuilder createReport(List<AnswerDto> answerDtos) {
        this.answerDtos = answerDtos;
        reportDto = new ReportDto();
        return this;
    }

    public ReportBuilder addReportItems() {
        for (AnswerDto answerDto : answerDtos) {
            ReportItem reportItem = new ReportItem();
            Question question = questionService.findQuestionById(answerDto.getId());
            reportItem.setTheme(question.getTheme());
            reportItem.setQuestion(question.getQuestion());
            reportItem.setExplanation(question.getExplanation());
            reportItem.setCorrectAnswers(getCorrectAnswer(question));
            reportItem.setUserAnswers(answerDto.getAnswers());
            reportDto.getReportItems().add(reportItem);
        }
        return this;
    }

    public ReportDto build() {
        return reportDto;
    }


    private List<String> getCorrectAnswer(Question question) {
        return question.getAnswers().stream().filter(Answer::isCorrect).map(Answer::getAnswer).toList();
    }



}
