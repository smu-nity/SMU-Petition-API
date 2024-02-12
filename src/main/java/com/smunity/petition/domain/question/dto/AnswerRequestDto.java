package com.smunity.petition.domain.question.dto;


import com.smunity.petition.domain.question.entity.Answer;
import jakarta.validation.constraints.NotBlank;

public record AnswerRequestDto(
        @NotBlank(message = "[ERROR] 내용은 필수 입력 항목 입니다.")
        String content
) {
    public Answer toEntity() {
        return Answer.builder()
                .content(content)
                .build();
    }
}
