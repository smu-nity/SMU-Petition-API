package com.smunity.petition.domain.account.repository.user;

import com.smunity.petition.domain.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);
}
