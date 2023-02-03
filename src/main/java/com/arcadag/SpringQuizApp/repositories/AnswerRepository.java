package com.arcadag.SpringQuizApp.repositories;

import com.arcadag.SpringQuizApp.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
