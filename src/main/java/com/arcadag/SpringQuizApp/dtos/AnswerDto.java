package com.arcadag.SpringQuizApp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class AnswerDto {
    Long id;
    List<String> answers;

}
