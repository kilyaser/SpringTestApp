package com.arcadag.SpringQuizApp.servicies;

import com.arcadag.SpringQuizApp.domain.QuizBuilder;
import com.arcadag.SpringQuizApp.models.QuestionItem;
import com.arcadag.SpringQuizApp.models.Quiz;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizService {
    private final QuizBuilder quizBuilder;


    public List<QuestionItem> getQuiz() {
        List<QuestionItem> items = new ArrayList<>();
        Quiz quiz = quizBuilder.create()
                .addQuestions()
                .build();

        Set<Long> keySet = quiz.getQuizData().keySet();
        for(Long key : keySet) {
            items.add(quiz.getQuizData().get(key));
        }
        log.info("items size in QuizService {}", items.size());
        return items;
    }


}
