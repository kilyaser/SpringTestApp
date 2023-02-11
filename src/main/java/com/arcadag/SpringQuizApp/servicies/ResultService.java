package com.arcadag.SpringQuizApp.servicies;

import com.arcadag.SpringQuizApp.dtos.AnswerDto;
import com.arcadag.SpringQuizApp.dtos.ResultDto;
import com.arcadag.SpringQuizApp.entity.Answer;
import com.arcadag.SpringQuizApp.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final QuestionService questionService;
    @Value("${quiz.question.quantity}")
    private int totalQuestion;
    public ResultDto check(List<AnswerDto> answers) {
        ResultDto resultDto = new ResultDto();
        resultDto.setTotalQuestion(totalQuestion);

        int countCorrectAnswer = 0;

        for (AnswerDto answerDto : answers) {
            Long id = answerDto.getId();
            List<String> answerDtoList = answerDto.getAnswers();

            Question question = questionService.findQuestionById(id);
            String theme = question.getTheme();

            List<String> correctAnswer = question.getAnswers().stream()
                    .filter(Answer::isCorrect)
                    .map(Answer::getAnswer)
                    .toList();

            if (matchAllQuestion(correctAnswer, answerDtoList)) {
                countCorrectAnswer++;
            } else {
                if (!resultDto.getThemes().contains(theme)) {
                    resultDto.getThemes().add(theme);
                }
            }
        }
        resultDto.setCorrectAnswers(countCorrectAnswer);

        return resultDto;
    }

    public boolean matchAllQuestion(List<String> correctAnswers, List<String> answers) {
        if (correctAnswers.size() != answers.size()) {
            return false;
        }

        if (answers.containsAll(correctAnswers)) {
            return true;
        } else {
            return false;
        }
    }
}
