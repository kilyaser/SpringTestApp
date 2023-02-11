package com.arcadag.SpringQuizApp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ReportItem {
    private String theme;
    private String question;
    private List<String> correctAnswers;
    private List<String> userAnswers;
    private String explanation;
}
