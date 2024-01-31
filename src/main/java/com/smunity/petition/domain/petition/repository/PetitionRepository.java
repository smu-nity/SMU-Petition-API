package com.smunity.petition.domain.petition.repository;

import com.smunity.petition.domain.petition.dto.PetitionResponse;
import com.smunity.petition.domain.petition.entity.Petition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetitionRepository extends JpaRepository<Petition, Long> {

    @Query("select p from Petition p where p.id = :petitionId")
    Petition findByPetitionId(@Param("petitionId") Long petitionId);

    @Query("select p from Petition p")
    List<PetitionResponse.petitionList> findAllPetition();

    List<Petition> findAll();
}
