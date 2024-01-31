package com.smunity.petition.domain.petition.repository;

import com.smunity.petition.domain.petition.dto.CommentResponse;
import com.smunity.petition.domain.petition.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query( "select c " +
            "from Comment c " +
            "where c.petition.id = :petitionId")
    List<CommentResponse.commentDTO> findAllByPetitionId(@Param("petitionId") Long petitionId);
}
