package com.smunity.petition.domain.account.dto;

import com.smunity.petition.domain.account.entity.User;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserLoginResponseDto(
        Long userId,
        LocalDateTime createdAt,
        String token) {

    public static UserLoginResponseDto from(User user, String token) {
        return UserLoginResponseDto.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .token(token)
                .build();
    }
}
