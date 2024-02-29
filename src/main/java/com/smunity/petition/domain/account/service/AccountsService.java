package com.smunity.petition.domain.account.service;

import com.smunity.petition.domain.account.dto.UserLoginRequestDto;
import com.smunity.petition.domain.account.dto.UserLoginResponseDto;
import com.smunity.petition.domain.account.dto.UserSignupRequestDto;
import com.smunity.petition.domain.account.dto.UserSignupResponseDto;
import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.account.exception.AccountsExceptionHandler;
import com.smunity.petition.domain.account.jwt.config.JwtProvider;
import com.smunity.petition.domain.account.repository.UserRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class AccountsService {
    private final UserRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public UserLoginResponseDto login(UserLoginRequestDto requestDto) {

        // 회원 정보 존재 하는지 확인
        User user = userJpaRepository.findByUserName(requestDto.userName())
                .orElseThrow(() -> new AccountsExceptionHandler(ErrorCode.USER_NOT_FOUND));

        // 회원 pw 일치 여부
        if (!passwordEncoder.matches(requestDto.password(), user.getPassword())) {
            throw new AccountsExceptionHandler(ErrorCode.PASSWORD_NOT_EQUAL);
        }

        // 로그인 성공 시 토큰 생성
        String token = jwtProvider.createToken(user.getId().toString(), user.getRoles());

        return UserLoginResponseDto.from(user, token);
    }

    public UserSignupResponseDto signup(UserSignupRequestDto requestDto) {

        // pw, pw 확인 일치 확인
        if (!requestDto.password().equals(requestDto.passwordCheck()))
            throw new AccountsExceptionHandler(ErrorCode.PASSWORD_NOT_EQUAL);

        // 학번 중복 확인
        if (userJpaRepository.existsByUserName(requestDto.userName())) {
            throw new AccountsExceptionHandler(ErrorCode.USER_ALREADY_EXIST);
        }

        String encodedPw = passwordEncoder.encode(requestDto.password());
        User user = requestDto.toEntity(encodedPw);

        return UserSignupResponseDto.from(userJpaRepository.save(user));
    }

}
