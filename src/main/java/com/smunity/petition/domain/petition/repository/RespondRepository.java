package com.smunity.petition.domain.petition.repository;

import com.smunity.petition.domain.petition.dto.RespondResponse;
import com.smunity.petition.domain.petition.entity.Respond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RespondRepository extends JpaRepository<Respond, Long> {

    @Query( "select r " +
            "from Respond r " +
            "where r.petition.id = :petitionId")
    RespondResponse.respondDTO findByPetitionId(@Param("petitionId") Long petitionId);
}
