package com.arcadag.SpringTestApp.models;

import com.arcadag.SpringTestApp.entities.Answer;
import com.arcadag.SpringTestApp.entities.Question;
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
