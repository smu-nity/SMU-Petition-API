package com.smunity.petition.domain.question.dto;

import com.smunity.petition.domain.question.entity.Question;
import lombok.Builder;

import java.util.List;

@Builder
public record QuestionListDto(
        Long id,
        String subject
) {
    public static QuestionListDto from(Question question){
        return QuestionListDto.builder()
                .id(question.getId())
                .subject(question.getSubject())
                .build();
    }

    public static List<QuestionListDto> from(List<Question> questionList){
        return questionList.stream().map(QuestionListDto::from).toList();
    }
}
