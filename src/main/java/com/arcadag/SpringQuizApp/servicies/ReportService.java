package com.arcadag.SpringQuizApp.servicies;

import com.arcadag.SpringQuizApp.domain.ReportBuilder;
import com.arcadag.SpringQuizApp.dtos.AnswerDto;
import com.arcadag.SpringQuizApp.dtos.ReportDto;
import com.arcadag.SpringQuizApp.dtos.ReportItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportBuilder reportBuilder;
    public ReportDto getReport(List<AnswerDto> answerDtos) {
            return reportBuilder
                    .createReport(answerDtos)
                    .addReportItems()
                    .build();

    }
}
