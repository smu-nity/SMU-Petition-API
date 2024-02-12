package com.smunity.petition.domain.question.controller;

import com.smunity.petition.domain.question.dto.QuestionDto;
import com.smunity.petition.domain.question.dto.QuestionListDto;
import com.smunity.petition.domain.question.dto.QuestionRequestDto;
import com.smunity.petition.domain.question.entity.Question;
import com.smunity.petition.domain.question.service.QuestionService;
import com.smunity.petition.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public List<QuestionListDto> list() {
        return questionService.getQuestion();
    }

    @GetMapping("/{question_id}")
    public QuestionDto read(@PathVariable Long question_id) {
        return questionService.getQuestionById(question_id);
    }

    @PostMapping
    public Question create(@RequestBody QuestionRequestDto question) {
        return questionService.save(question);
    }

    @PatchMapping("/{question_id}")
    public QuestionRequestDto update(@RequestBody QuestionRequestDto question,
                                     @PathVariable Long question_id) {
        return questionService.update(question_id, question);
    }

    @DeleteMapping("/{question_id}")
    public ApiResponse<Void> delete(@PathVariable Long question_id) {
        return ApiResponse.noContent();
    }
}