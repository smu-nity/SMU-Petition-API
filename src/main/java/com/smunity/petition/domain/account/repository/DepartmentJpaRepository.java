package com.smunity.petition.domain.account.repository;

import com.smunity.petition.domain.account.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentJpaRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);
}
