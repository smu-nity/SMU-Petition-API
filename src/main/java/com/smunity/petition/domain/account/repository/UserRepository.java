package com.smunity.petition.domain.account.repository;

import com.smunity.petition.domain.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.id = :userId")
    User findByuserId(@Param("userId") Long userid);

    Optional<User> findByUserName(String userName);
}
