package com.smunity.petition.domain.petition.repository;

import com.smunity.petition.domain.petition.entity.Petition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetitionRepository extends JpaRepository<Petition, Long> {
}
