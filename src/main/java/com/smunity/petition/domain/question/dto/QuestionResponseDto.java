package com.smunity.petition.domain.question.dto;

import com.smunity.petition.domain.question.entity.Question;
import lombok.Builder;

@Builder
public record QuestionResponseDto(
        Long id,
        String subject,
        String content,
        boolean anonymous
) {
    public static QuestionResponseDto from(Question question) {
        return QuestionResponseDto.builder()
                .id(question.getId())
                .subject(question.getSubject())
                .content(question.getContent())
                .anonymous(question.isAnonymous())
                .build();
    }

}
