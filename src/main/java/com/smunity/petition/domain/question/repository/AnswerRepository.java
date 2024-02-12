package com.smunity.petition.domain.question.repository;

import com.smunity.petition.domain.question.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Optional<Answer> findByContent(String content);

    Optional<Answer> findByQuestionId(Long questionId);
}
