package com.smunity.petition.domain.account.dto;

import com.smunity.petition.domain.account.entity.User;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserSignupResponseDto(
        Long id,
        String email,
        String userName,
        LocalDateTime createdAt) {
    public static UserSignupResponseDto from(User user) {
        return UserSignupResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .userName(user.getUsername())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
