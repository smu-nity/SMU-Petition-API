package com.smunity.petition.domain.question.repository;

import com.smunity.petition.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
