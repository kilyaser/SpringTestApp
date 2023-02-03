package com.arcadag.SpringTestApp.servicies;

import com.arcadag.SpringTestApp.repositories.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;


}
