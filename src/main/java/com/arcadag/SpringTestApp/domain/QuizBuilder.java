package com.arcadag.SpringTestApp.domain;

import com.arcadag.SpringTestApp.entities.Answer;
import com.arcadag.SpringTestApp.entities.Question;
import com.arcadag.SpringTestApp.models.QuestionItem;
import com.arcadag.SpringTestApp.models.Quiz;
import com.arcadag.SpringTestApp.servicies.QuestionService;
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

    public Quiz create() {
        questions = questionService.countQuestions();
        Map<Long, QuestionItem> quizData = new HashMap<>();
        this.quiz = new Quiz();
        quiz.setQuizData(quizData);
        addQuestions(quiz);
        return quiz;
    }

    private void addQuestions(Quiz quiz) {
        while (quiz.getQuizData().size() < 5) {

            QuestionItem questionItem = new QuestionItem();

            Long id = (long) (Math.random() * questions) + 1;
            Question question = questionService.findQuestionById(id);
            List<Answer> correctAnswers = question.getAnswers();
            int quantityOfCorrectAnswer = (int) correctAnswers.stream().filter(Answer::isCorrect).count();

            questionItem.setId(id);
            questionItem.setQuestion(question);
            questionItem.setAnswer(correctAnswers);
            questionItem.setQuantityOfCorrectAnswer(quantityOfCorrectAnswer);
            quiz.getQuizData().put(id, questionItem);
        }
    }


}
