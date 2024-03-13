package com.smunity.petition.domain.petition.repository;

import com.smunity.petition.domain.petition.entity.Respond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RespondRepository extends JpaRepository<Respond, Long> {

    @Query( "select r " +
            "from Respond r " +
            "where r.petition.id = :petitionId")
    //RespondResponse.respondDetail -> Respond
    Respond findByPetitionId(@Param("petitionId") Long petitionId);

}
