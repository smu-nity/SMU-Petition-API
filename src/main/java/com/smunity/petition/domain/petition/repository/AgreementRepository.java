package com.smunity.petition.domain.petition.repository;

import com.smunity.petition.domain.petition.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
}
