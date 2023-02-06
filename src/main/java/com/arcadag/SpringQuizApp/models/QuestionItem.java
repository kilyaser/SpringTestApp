package com.arcadag.SpringQuizApp.models;

import com.arcadag.SpringQuizApp.entity.Answer;
import com.arcadag.SpringQuizApp.entity.Question;
import lombok.Data;

import java.util.List;

@Data
public class QuestionItem {
    private Long id;
    private int quantityOfCorrectAnswer;
    private Question question;
    private List<String> answer;

    public void setAnswer(List<Answer> answers) {
        this.answer = answers.stream().map(Answer::getAnswer).toList();
    }



}
