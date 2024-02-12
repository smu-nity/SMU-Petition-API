package com.smunity.petition.domain.question.dto;

import com.smunity.petition.domain.question.entity.Answer;
import com.smunity.petition.domain.question.entity.Question;
import lombok.Builder;

@Builder
public record AnswerResponseDto(
        Long id,
        Long questionId,
        String content
) {
    public static AnswerResponseDto from(Answer answer) {
        return AnswerResponseDto.builder()
                .id(answer.getId())
                .questionId(answer.getQuestion().getId())
                .content(answer.getContent())
                .build();

    }
}
