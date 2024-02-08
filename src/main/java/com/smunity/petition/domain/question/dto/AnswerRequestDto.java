package com.smunity.petition.domain.question.dto;


import jakarta.validation.constraints.NotBlank;

public record AnswerRequestDto(
        Long questionId,
        @NotBlank(message = "[ERROR] 내용은 필수 입력 항목 입니다.")
        String content
) {

}
