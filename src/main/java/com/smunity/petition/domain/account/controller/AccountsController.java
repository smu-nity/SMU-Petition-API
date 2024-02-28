package com.smunity.petition.domain.account.controller;

import com.smunity.petition.domain.account.annotation.AccountResolver;
import com.smunity.petition.domain.account.dto.UserRegisterRequestDto;
import com.smunity.petition.domain.account.dto.UserRegisterResponseDto;
import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.account.jwt.dto.JwtDto;
import com.smunity.petition.domain.account.jwt.exception.SecurityCustomException;
import com.smunity.petition.domain.account.jwt.exception.TokenErrorCode;
import com.smunity.petition.domain.account.jwt.util.JwtUtil;
import com.smunity.petition.domain.account.service.AccountsService;
import com.smunity.petition.global.common.ApiResponse;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
@RestController
public class AccountsController {

    private final AccountsService accountsService;

    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ApiResponse<UserRegisterResponseDto> register(@Valid @RequestBody UserRegisterRequestDto request) {
        return ApiResponse.onSuccess(accountsService.register(request));
    }

    @GetMapping("/reissue")
    public ApiResponse<JwtDto> reissueToken(@RequestHeader("RefreshToken") String refreshToken) {
        try {
            jwtUtil.validateRefreshToken(refreshToken);
            return ApiResponse.onSuccess(
                    jwtUtil.reissueToken(refreshToken)
            );
        } catch (ExpiredJwtException eje) {
            throw new SecurityCustomException(TokenErrorCode.TOKEN_EXPIRED, eje);
        } catch (IllegalArgumentException iae) {
            throw new SecurityCustomException(TokenErrorCode.INVALID_TOKEN, iae);
        }
    }

    @GetMapping("/test")
    public ApiResponse<String> register(@AccountResolver User user) {
        return ApiResponse.onSuccess(user.getUserName());
    }
}
