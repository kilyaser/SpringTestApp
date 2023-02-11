package com.arcadag.SpringQuizApp.domain;

import com.arcadag.SpringQuizApp.entity.Answer;
import com.arcadag.SpringQuizApp.entity.Question;
import com.arcadag.SpringQuizApp.models.QuestionItem;
import com.arcadag.SpringQuizApp.models.Quiz;
import com.arcadag.SpringQuizApp.servicies.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuizBuilder {
    private final QuestionService questionService;

    @Value("${quiz.question.quantity}")
    private int quantity;
    private Quiz quiz;
    private long questions;

    public QuizBuilder createQuiz() {
        questions = questionService.countQuestions();
        Map<Long, QuestionItem> quizData = new HashMap<>();
        this.quiz = new Quiz();
        quiz.setQuizData(quizData);
        return this;
    }

    public QuizBuilder addQuestions() {
        while (quiz.getQuizData().size() < quantity) {

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
