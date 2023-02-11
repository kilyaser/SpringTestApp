package com.arcadag.SpringQuizApp.controller;

import com.arcadag.SpringQuizApp.dtos.AnswerDto;
import com.arcadag.SpringQuizApp.dtos.ReportDto;
import com.arcadag.SpringQuizApp.servicies.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    @PostMapping
    public ReportDto getReport(@RequestBody List<AnswerDto> answers) {
        log.info(answers.toString());
        return reportService.getReport(answers);
    }


}
