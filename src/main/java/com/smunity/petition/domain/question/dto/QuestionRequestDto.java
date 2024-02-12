package com.smunity.petition.domain.question.dto;

import com.smunity.petition.domain.question.entity.Question;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionRequestDto {

    private Long id;
    private String subject;
    private String content;
    private boolean anonymous;
    private AnswerDto answer;

    public static QuestionRequestDto from(Question question) {
        return QuestionRequestDto.builder()
                .id(question.getId())
                .subject(question.getSubject())
                .content(question.getContent())
                .anonymous(question.isAnonymous())
                .answer(question.getAnswer() != null ? AnswerDto.from(question.getAnswer()) : null)
                .build();
    }

    public Question toEntity() {
        return Question.builder()
                .id(id)
                .subject(subject)
                .content(content)
                .anonymous(anonymous)
                .build();
    }
}