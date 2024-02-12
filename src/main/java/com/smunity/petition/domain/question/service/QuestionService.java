package com.smunity.petition.domain.question.service;

import com.smunity.petition.domain.question.dto.QuestionDto;
import com.smunity.petition.domain.question.dto.QuestionListDto;
import com.smunity.petition.domain.question.dto.QuestionRequestDto;
import com.smunity.petition.domain.question.entity.Question;
import com.smunity.petition.domain.question.repository.QuestionRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import com.smunity.petition.global.common.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<QuestionListDto> getQuestion() {
        List<Question> questions = questionRepository.findAll();
        return QuestionListDto.from(questions);
    }

    @Transactional
    public Question save(QuestionRequestDto question) {
        //TODO 로그인한 사용자 FK 연결
        return questionRepository.save(question.toEntity());
    }

    public QuestionDto getQuestionById(Long id) {
        Question QuestionEntity = questionRepository.findById(id).orElseThrow(
                () -> new GeneralException(ErrorCode.QUESTION_NOT_FOUND));
        return QuestionDto.from(QuestionEntity);
    }

    @Transactional
    public QuestionRequestDto update(Long question_id, QuestionRequestDto question) {
        Question questionEntity = questionRepository.findById(question_id).orElseThrow(()
                -> new GeneralException(ErrorCode.QUESTION_NOT_FOUND));
        questionEntity.update(question.getId(), question.getSubject(), question.getContent(), question.isAnonymous());
        return question;
    }

    @Transactional
    public void delete(Long questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new GeneralException(ErrorCode.QUESTION_NOT_FOUND));
        questionRepository.delete(question);
    }
}
