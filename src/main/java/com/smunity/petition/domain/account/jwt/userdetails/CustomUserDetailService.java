package com.smunity.petition.domain.account.jwt.userdetails;

import com.smunity.petition.domain.account.exception.AccountsExceptionHandler;
import com.smunity.petition.domain.account.repository.UserRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String userPk) throws UsernameNotFoundException {
        return (UserDetails) userJpaRepository.findById(Long.parseLong(userPk))
                .orElseThrow(() -> new AccountsExceptionHandler(ErrorCode.USER_NOT_FOUND));
    }
}
