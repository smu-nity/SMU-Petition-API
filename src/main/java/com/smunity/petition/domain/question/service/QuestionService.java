package com.smunity.petition.domain.question.service;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.account.repository.UserRepository;
import com.smunity.petition.domain.question.dto.QuestionListDto;
import com.smunity.petition.domain.question.dto.QuestionRequestDto;
import com.smunity.petition.domain.question.dto.QuestionResponseDto;
import com.smunity.petition.domain.question.entity.Question;
import com.smunity.petition.domain.question.repository.QuestionRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import com.smunity.petition.global.common.exception.GeneralException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public List<QuestionListDto> getQuestion() {
        List<Question> questions = questionRepository.findAll();
        return QuestionListDto.from(questions);
    }


    public QuestionResponseDto getQuestionById(Long id) {
        Question QuestionEntity = questionRepository.findById(id).orElseThrow(
                () -> new GeneralException(ErrorCode.QUESTION_NOT_FOUND));
        return QuestionResponseDto.from(QuestionEntity);
    }


    // public QuestionResponseDto createQuestion(QuestionRequestDto requestDto){
        // 인증된 사용자인지 아닌지 검사 코드 필요

        // Question saveQuestion = questionRepository.save(requestDto.toEntity(user));
        // return QuestionResponseDto.from(saveQuestion);
    // }

    public QuestionResponseDto updateQuestion(Long questionId, QuestionRequestDto requestDto) {
        Question existQuestion = questionRepository.findById(questionId)
                .orElseThrow(() -> new GeneralException(ErrorCode.QUESTION_NOT_FOUND));
        // 작성자와 접근자가 같은 사람인지 확인하는 로직 필요할 것 같음
        existQuestion.setSubject(requestDto.subject());
        existQuestion.setContent(requestDto.content());
        existQuestion.setAnonymous(requestDto.anonymous());
        Question updateQuestion = questionRepository.save(existQuestion);
        return QuestionResponseDto.from(updateQuestion);
    }

    public void deleteQuestion(Long questionId) {
        Question existQuestion = questionRepository.findById(questionId)
                .orElseThrow(() -> new GeneralException(ErrorCode.QUESTION_NOT_FOUND));
        // 작성자와 접근자가 같은 사람인지 확인하는 로직 필요할 것 같음
        questionRepository.delete(existQuestion);
    }
}
