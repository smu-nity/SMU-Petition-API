package com.smunity.petition.domain.petition.repository;

import com.smunity.petition.domain.petition.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
