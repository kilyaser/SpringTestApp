package com.arcadag.SpringQuizApp.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Data
public class QuestionItemDto {
    private Long id;
    private String theme;
    private String question;
    private List<String> answers;
    private int quantityOfCorrectAnswer;
}
