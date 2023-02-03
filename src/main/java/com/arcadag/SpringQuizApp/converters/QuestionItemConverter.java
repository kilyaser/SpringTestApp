package com.arcadag.SpringQuizApp.converters;

import com.arcadag.SpringQuizApp.dtos.QuestionItemDto;
import com.arcadag.SpringQuizApp.models.QuestionItem;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionItemConverter {

    public List<QuestionItemDto> toQuestionItemDto(List<QuestionItem> items) {
        List<QuestionItemDto> itemDtos = new ArrayList<>();
        for (QuestionItem item : items) {
            QuestionItemDto dto = new QuestionItemDto();
            dto.setId(item.getId());
            dto.setQuestion(item.getQuestion().getQuestion());
            dto.setTheme(item.getQuestion().getTheme());
            dto.setAnswers(item.getAnswer());
            dto.setQuantityOfCorrectAnswer(item.getQuantityOfCorrectAnswer());
            itemDtos.add(dto);
        }
        return itemDtos;
    }
}
