package com.arcadag.SpringQuizApp.repositories;

import com.arcadag.SpringQuizApp.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {


}
