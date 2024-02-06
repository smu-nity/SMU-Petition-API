package com.smunity.petition.domain.question.dto;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.question.entity.Question;
import jakarta.validation.constraints.NotBlank;

public record QuestionRequestDto(
        @NotBlank(message = "[ERROR] 제목 입력은 필수 입니다.")
        String subject,
        @NotBlank(message = "[ERROR] 내용은 필수 입력 항목 입니다.")
        String content,
        boolean anonymous
) {
    public Question toEntity(User user) {
        return Question.builder()
                .subject(subject)
                .content(content)
                .anonymous(anonymous)
                .user(user)
                .build();
    }
}
