package com.arcadag.SpringQuizApp.servicies;

import com.arcadag.SpringQuizApp.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;


}
