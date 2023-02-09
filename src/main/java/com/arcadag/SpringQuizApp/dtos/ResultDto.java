package com.arcadag.SpringQuizApp.dtos;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResultDto {
    private int totalQuestion;
    private int correctAnswers;
    private List<String> themes = new ArrayList<>();
}
