package com.arcadag.SpringQuizApp.domain;

import com.arcadag.SpringQuizApp.dtos.AnswerDto;
import com.arcadag.SpringQuizApp.dtos.ReportDto;
import com.arcadag.SpringQuizApp.dtos.ReportItem;
import com.arcadag.SpringQuizApp.entity.Answer;
import com.arcadag.SpringQuizApp.entity.Question;
import com.arcadag.SpringQuizApp.servicies.QuestionService;
import com.arcadag.SpringQuizApp.servicies.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReportBuilder {
    private final QuestionService questionService;
    private final ResultService resultService;
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
                if (!resultService.matchAllQuestion(getCorrectAnswer(question), answerDto.getAnswers())){
                    reportItem.setCorrectAnswers(getCorrectAnswer(question));
                    reportItem.setUserAnswers(isUserAnswered(answerDto.getAnswers()));
                    reportItem.setTheme(question.getTheme());
                    reportItem.setQuestion(question.getQuestion());
                    reportItem.setExplanation(question.getExplanation());
                    reportDto.getReportItems().add(reportItem);
                }

            }
        return this;
    }

    public ReportDto build() {
        return reportDto;
    }

    private List<String> isUserAnswered(List<String> userAnswers) {
        if (userAnswers.size() == 0) {
            userAnswers.add("You didn't answer the question.");
        }
        return userAnswers;
    }



    private List<String> getCorrectAnswer(Question question) {
        return question.getAnswers().stream().filter(Answer::isCorrect).map(Answer::getAnswer).toList();
    }



}
