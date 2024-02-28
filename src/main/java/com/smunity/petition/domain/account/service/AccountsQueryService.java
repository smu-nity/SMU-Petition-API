package com.smunity.petition.domain.account.service;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.account.exception.AccountsExceptionHandler;
import com.smunity.petition.domain.account.repository.user.UserRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AccountsQueryService {

    private final UserRepository userRepository;

    public User findByUserName(String username) {
        return userRepository.findByUserName(username)
                .orElseThrow(() -> new AccountsExceptionHandler(ErrorCode.USER_NOT_FOUND));
    }
}
