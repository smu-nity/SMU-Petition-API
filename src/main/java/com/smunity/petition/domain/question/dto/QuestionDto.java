package com.smunity.petition.domain.question.dto;

import com.smunity.petition.domain.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private Long id;
    private String subject;
    private String content;
    private boolean anonymous;

    public void setId(Long id) {
        id = id;
    }

    public void setSubject(String subject) {
        subject = subject;
    }

    public void setContent(String content) {
        content = content;
    }

    public void setAnonymous(boolean anonymous) {
        anonymous = anonymous;
    }
    public static QuestionDto toQuestionDto(Question question) {
        QuestionDto questionsResponseDto = new QuestionDto();
        questionsResponseDto.setId(question.getId());
        questionsResponseDto.setSubject(question.getSubject());
        questionsResponseDto.setContent(question.getContent());
        questionsResponseDto.setAnonymous(question.isAnonymous());
        return questionsResponseDto;
    }
}
