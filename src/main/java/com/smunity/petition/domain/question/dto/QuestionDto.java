package com.smunity.petition.domain.question.dto;

import com.smunity.petition.domain.question.entity.Question;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionDto {

    private Long id;
    private String subject;
    private String content;
    private boolean anonymous;

    public static QuestionDto from(Question question) {
        return QuestionDto.builder()
                .id(question.getId())
                .subject(question.getSubject())
                .content(question.getContent())
                .anonymous(question.isAnonymous())
                .build();
    }
}
