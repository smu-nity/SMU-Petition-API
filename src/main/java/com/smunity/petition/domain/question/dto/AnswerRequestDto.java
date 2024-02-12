package com.smunity.petition.domain.question.dto;

import com.smunity.petition.domain.question.entity.Answer;
import com.smunity.petition.domain.question.entity.Question;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AnswerRequestDto {
    private Long id;
    private Long question_id;
    private String content;

    public static AnswerRequestDto from(Answer answer) {
        return AnswerRequestDto.builder()
                .id(answer.getId())
                .question_id(answer.getQuestion().getId())
                .content(answer.getContent())
                .build();
    }

    public Answer toEntity(Question questionEntity) {
        return Answer.builder()
                .id(id)
                .content(content)
                .question(questionEntity)
                .build();
    }
}

