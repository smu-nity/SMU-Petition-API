package com.smunity.petition.domain.account.repository;


import com.smunity.petition.domain.account.entity.Year;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface YearJpaRepository extends JpaRepository<Year, Long> {

    Optional<Year> findByYear(String year);
}
