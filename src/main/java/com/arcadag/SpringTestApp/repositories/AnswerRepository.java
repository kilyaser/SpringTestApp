package com.arcadag.SpringTestApp.repositories;

import com.arcadag.SpringTestApp.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
