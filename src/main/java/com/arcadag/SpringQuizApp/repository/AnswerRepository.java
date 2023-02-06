package com.arcadag.SpringQuizApp.repository;

import com.arcadag.SpringQuizApp.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
