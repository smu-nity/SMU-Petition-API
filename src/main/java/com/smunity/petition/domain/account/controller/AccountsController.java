package com.smunity.petition.domain.account.controller;

import com.smunity.petition.domain.account.dto.UserLoginRequestDto;
import com.smunity.petition.domain.account.dto.UserLoginResponseDto;
import com.smunity.petition.domain.account.dto.UserSignupRequestDto;
import com.smunity.petition.domain.account.dto.UserSignupResponseDto;
import com.smunity.petition.domain.account.service.AccountsService;
import com.smunity.petition.global.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountsController {
    private final AccountsService accountsService;

    @PostMapping("/login")
    public ApiResponse<UserLoginResponseDto> login(@Valid @RequestBody UserLoginRequestDto requestDto) {
        return ApiResponse.onSuccess(accountsService.login(requestDto));
    }

    @PostMapping("/signup")
    public ApiResponse<UserSignupResponseDto> signup(@Valid @RequestBody UserSignupRequestDto requestDto) {
        return ApiResponse.onSuccess(accountsService.signup(requestDto));
    }
}
