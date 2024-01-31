package com.smunity.petition.domain.question.service;

import com.smunity.petition.domain.question.dto.QuestionDto;
import com.smunity.petition.domain.question.dto.QuestionListDto;
import com.smunity.petition.domain.question.entity.Question;
import com.smunity.petition.domain.question.repository.QuestionRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import com.smunity.petition.global.common.exception.GeneralException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {
    private final QuestionRepository questionRepository;


    public List<QuestionListDto> getQuestion() {
        List<Question> questions = questionRepository.findAll();
        return QuestionListDto.from(questions);
    }


    public QuestionDto getQuestionById(Long id) {
        Question QuestionEntity = questionRepository.findById(id).orElseThrow(
                () -> new GeneralException(ErrorCode.QUESTION_NOT_FOUND));
        return QuestionDto.from(QuestionEntity);

    }
}
