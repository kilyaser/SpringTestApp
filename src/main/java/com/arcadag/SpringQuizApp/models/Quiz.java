package com.arcadag.SpringQuizApp.models;

import lombok.Data;
import java.util.Map;

@Data
public class Quiz {
    private Map<Long, QuestionItem> quizData;

}
