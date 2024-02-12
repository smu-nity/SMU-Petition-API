package com.smunity.petition.domain.question.repository;

import com.smunity.petition.domain.question.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
