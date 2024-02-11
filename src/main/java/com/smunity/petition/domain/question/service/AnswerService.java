package com.smunity.petition.domain.question.service;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.account.repository.UserRepository;
import com.smunity.petition.domain.question.dto.AnswerRequestDto;
import com.smunity.petition.domain.question.dto.AnswerResponseDto;
import com.smunity.petition.domain.question.dto.QuestionResponseDto;
import com.smunity.petition.domain.question.entity.Answer;
import com.smunity.petition.domain.question.entity.Question;
import com.smunity.petition.domain.question.repository.AnswerRepository;
import com.smunity.petition.domain.question.repository.QuestionRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import com.smunity.petition.global.common.exception.GeneralException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    // private final QuestionRepository questionRepository;
    // private final UserRepository userRepository;

    public AnswerResponseDto getAnswer(Long questionId) {
        Answer AnswerEntity = answerRepository.findByQuestionId(questionId).orElseThrow(
                () -> new GeneralException(ErrorCode.QUESTION_NOT_FOUND));
        return AnswerResponseDto.from(AnswerEntity);
    }

    // Create Code 작성 필요
//    public AnswerResponseDto createAnswer(Long questionId, AnswerRequestDto answerRequestDto){

//        Question question = questionRepository.findById(questionId)
//                .orElseThrow(() -> new GeneralException(ErrorCode.QUESTION_NOT_FOUND));
//        Answer saveAnswer = answerRepository.save(new Answer())
//    }

    public AnswerResponseDto updateAnswer(Long answerId, AnswerRequestDto answerRequestDto){
        Answer existingAnswer = answerRepository.findById(answerId)
                .orElseThrow(() -> new GeneralException(ErrorCode.ANSWER_NOT_FOUND));
        // 관리자 권한이 있는지 체크하는 코드 필요할거 같음
        existingAnswer.setContent(answerRequestDto.content());
        Answer updateAnswer = answerRepository.save(existingAnswer);
        return AnswerResponseDto.from(updateAnswer);
    }

    public void deleteAnswer(Long answerId) {
        Answer existingAnswer = answerRepository.findById(answerId)
                .orElseThrow(() -> new GeneralException(ErrorCode.ANSWER_NOT_FOUND));
        // 관리자 권한이 있는지 체크하는 코드 필요할거 같음
        answerRepository.delete(existingAnswer);
    }


}
