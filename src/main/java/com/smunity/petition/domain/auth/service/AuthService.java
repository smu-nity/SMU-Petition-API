package com.smunity.petition.domain.auth.service;

import com.smunity.petition.domain.auth.dto.AuthRequestDto;
import com.smunity.petition.domain.auth.dto.AuthResponseDto;
import com.smunity.petition.domain.auth.exception.AuthExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final WebClient webClient;

    public AuthResponseDto authenticate(AuthRequestDto requestDto) {
        return webClient.post()
                .uri("/api/userinfo")
                .bodyValue(requestDto)
                .retrieve()
                .onStatus(HttpStatusCode::isError, AuthExceptionHandler::handleError)
                .toEntity(AuthResponseDto.class)
                .block()
                .getBody();
    }
}
