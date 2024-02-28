package com.smunity.petition.domain.account.repository.user;


import com.smunity.petition.domain.account.entity.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUserName(String username);

    User save(User user);
}
