package com.smunity.petition.domain.question.dto;

import com.smunity.petition.domain.question.entity.Answer;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AnswerDto {
    private Long id;
    private String content;

    public static AnswerDto from(Answer answer) {
        return AnswerDto.builder()
                .id(answer.getId())
                .content(answer.getContent())
                .build();
    }
}
