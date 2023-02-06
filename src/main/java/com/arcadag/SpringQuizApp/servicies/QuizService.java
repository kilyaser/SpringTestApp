package com.arcadag.SpringQuizApp.servicies;

import com.arcadag.SpringQuizApp.domain.QuizBuilder;
import com.arcadag.SpringQuizApp.models.QuestionItem;
import com.arcadag.SpringQuizApp.models.Quiz;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class QuizService {
    private final QuizBuilder quizBuilder;

    public List<QuestionItem> getQuiz() {
        List<QuestionItem> items;
        Quiz quiz = quizBuilder.create()
                .addQuestions()
                .build();

        items = quiz.getQuizData().values().stream().toList();
        return items;
    }


}
