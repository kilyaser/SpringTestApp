package com.arcadag.SpringQuizApp.servicies;
import com.arcadag.SpringQuizApp.dtos.AnswerDto;
import com.arcadag.SpringQuizApp.dtos.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AnswerService {
    private final ResultService resultService;
    public ResultDto checkAnswers(List<AnswerDto> answers) {
        return resultService.check(answers);
    }


}
