package com.smunity.petition.domain.petition.repository;

import com.smunity.petition.domain.petition.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {

    @Query( "select a " +
            "from Agreement a " +
            "where a.petition.id = :petitionId and a.user_id = :userId")
    Agreement findByPetitionIdUAndUser_id(@Param("petitionId") Long petitionId, @Param("userId") Long userId);

    @Query("select a from Agreement a where a.petition.id = :petitionId")
    List<Agreement> findAllByPetitionId(@Param("petitionId") Long petitionId);
}
