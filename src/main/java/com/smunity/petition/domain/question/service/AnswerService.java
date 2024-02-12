package com.smunity.petition.domain.question.service;

import com.smunity.petition.domain.question.dto.AnswerDto;
import com.smunity.petition.domain.question.dto.AnswerRequestDto;
import com.smunity.petition.domain.question.entity.Answer;
import com.smunity.petition.domain.question.entity.Question;
import com.smunity.petition.domain.question.repository.AnswerRepository;
import com.smunity.petition.domain.question.repository.QuestionRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import com.smunity.petition.global.common.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnswerService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public AnswerDto getAnswerByQuestionId(Long question_id) {
        Answer answer = answerRepository.findByQuestionId(question_id).orElseThrow(() -> new GeneralException(ErrorCode.ANSWER_NOT_FOUND));
        return AnswerDto.from(answer);
    }

    @Transactional
    public AnswerDto save(AnswerRequestDto answer, Long question_id) {
        Question questionEntity = questionRepository.findById(question_id)
                .orElseThrow(() -> new GeneralException(ErrorCode.QUESTION_NOT_FOUND));
        return AnswerDto.from(answerRepository.save(answer.toEntity(questionEntity)));
    }

    @Transactional
    public void delete(Long answerId) {
        Answer answer = answerRepository.findById(answerId).orElseThrow(() -> new GeneralException(ErrorCode.ANSWER_NOT_FOUND));
        answerRepository.delete(answer);
    }

    @Transactional
    public AnswerRequestDto update(Long answer_id, AnswerRequestDto answer) {
        Answer answerEntity = answerRepository.findById(answer_id).orElseThrow(()
                -> new GeneralException(ErrorCode.ANSWER_NOT_FOUND));
        answerEntity.update(answer.getId(), answer.getContent());
        return answer;
    }
}
