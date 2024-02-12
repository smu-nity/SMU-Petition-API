package com.smunity.petition.domain.question.repository;

import com.smunity.petition.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAll();

    Optional<Question> findById(Long id);

    Question delete(Optional<Question> byId);
}
