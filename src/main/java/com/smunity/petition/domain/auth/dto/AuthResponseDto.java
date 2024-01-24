package com.smunity.petition.domain.auth.dto;

public record AuthResponseDto(
        String name,
        String department,
        String email
) {
}
