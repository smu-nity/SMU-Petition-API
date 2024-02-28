package com.smunity.petition.domain.account.jwt.userdetails;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.account.exception.AccountsExceptionHandler;
import com.smunity.petition.domain.account.repository.user.UserRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new AccountsExceptionHandler(ErrorCode.USER_NOT_FOUND));

        log.info("[*] User found : " + user.getUserName());

        return new CustomUserDetails(user);
    }

    public User userDetailsToUser(UserDetails userDetails) {
        return userRepository.findByUserName(userDetails.getUsername())
                .orElseThrow(() -> new AccountsExceptionHandler(ErrorCode.USER_NOT_FOUND));
    }
}
