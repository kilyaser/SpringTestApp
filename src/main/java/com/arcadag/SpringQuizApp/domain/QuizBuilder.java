package com.arcadag.SpringQuizApp.domain;

import com.arcadag.SpringQuizApp.entities.Answer;
import com.arcadag.SpringQuizApp.entities.Question;
import com.arcadag.SpringQuizApp.models.QuestionItem;
import com.arcadag.SpringQuizApp.models.Quiz;
import com.arcadag.SpringQuizApp.servicies.QuestionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Slf4j
@Component
@RequiredArgsConstructor
public class QuizBuilder {
    private final QuestionService questionService;
    private Quiz quiz;
    private long questions;

    public QuizBuilder create() {
        questions = questionService.countQuestions();
        Map<Long, QuestionItem> quizData = new HashMap<>();
        this.quiz = new Quiz();
        quiz.setQuizData(quizData);
        return this;
    }

    public QuizBuilder addQuestions() {
        while (quiz.getQuizData().size() < 5) {

            QuestionItem questionItem = new QuestionItem();

            Long id = (long) (Math.random() * questions) + 1;
            Question question = questionService.findQuestionById(id);
            List<Answer> answers = question.getAnswers();
            int quantityOfCorrectAnswer = (int) answers.stream().filter(Answer::isCorrect).count();

            questionItem.setId(id);
            questionItem.setQuestion(question);
            questionItem.setAnswer(answers);
            questionItem.setQuantityOfCorrectAnswer(quantityOfCorrectAnswer);
            quiz.getQuizData().put(id, questionItem);
        }
        return this;
    }

    public Quiz build() {
        return quiz;
    }


}
