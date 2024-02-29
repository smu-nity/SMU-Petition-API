package com.smunity.petition.domain.account.jwt.dto;

public record JwtDto(
        String accessToken,
        String refreshToken) {
}
