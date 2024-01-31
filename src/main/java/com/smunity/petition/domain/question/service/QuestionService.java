package com.smunity.petition.domain.question.service;

import com.smunity.petition.domain.question.dto.QuestionDto;
import com.smunity.petition.domain.question.dto.QuestionListDto;
import com.smunity.petition.domain.question.entity.Question;
import com.smunity.petition.domain.question.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Transactional
    public List<QuestionDto> findAll() {
        List<Question> questionEntityList = questionRepository.findAll();
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Question question : questionEntityList) {
            questionDtoList.add(QuestionDto.toQuestionDto(question));
        }
        return questionDtoList;
    }

    @Transactional
    public List<QuestionListDto> findList() {
        List<QuestionDto> questions = findAll();
        List<QuestionListDto> questionList = new ArrayList<>();
        for (QuestionDto questionDto : questions) {
            QuestionListDto questionListDto = new QuestionListDto(questionDto.getId(), questionDto.getContent());
            questionList.add(questionListDto);
        }

        return questionList;
    }

    @Transactional
    public QuestionDto findById(Long id) {
        Optional<Question> optionalQuestionEntity = questionRepository.findById(id);
        if (optionalQuestionEntity.isPresent()) {
            Question question = optionalQuestionEntity.get();
            return QuestionDto.toQuestionDto(question);
        } else {
            return null;
        }
    }
}
