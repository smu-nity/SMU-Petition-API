package com.smunity.petition.domain.account.repository.user;

import com.smunity.petition.domain.account.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;


    @Override
    public Optional<User> findByUserName(String username) {
        return userJpaRepository.findByUserName(username);
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }
}
