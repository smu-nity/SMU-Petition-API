package com.smunity.petition.domain.question.controller;

import com.smunity.petition.domain.question.dto.QuestionListDto;
import com.smunity.petition.domain.question.dto.QuestionRequestDto;
import com.smunity.petition.domain.question.dto.QuestionResponseDto;
import com.smunity.petition.domain.question.service.QuestionService;
import com.smunity.petition.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public ApiResponse<List<QuestionListDto>> list() {
        return ApiResponse.onSuccess(questionService.getQuestion());
    }

    @GetMapping("/{id}")
    public ApiResponse<QuestionResponseDto> read(@PathVariable Long id) {
        return ApiResponse.onSuccess(questionService.getQuestionById(id));
    }

    @PostMapping
    public ApiResponse<QuestionResponseDto> createQuestion(
            @RequestBody QuestionRequestDto requestDto) {
        return ApiResponse.onSuccess(questionService.createQuestion(requestDto));
    }

    @PatchMapping("/{questionId}")
    public ApiResponse<QuestionResponseDto> updateQuestion(
            @PathVariable Long questionId,
            @RequestBody QuestionRequestDto requestDto) {
        return ApiResponse.onSuccess(questionService.updateQuestion(questionId, requestDto));
    }

    @DeleteMapping("/{questionId}")
    public ApiResponse<Void> deleteQuestion(
            @PathVariable Long questionId) {
        questionService.deleteQuestion(questionId);
        return ApiResponse.noContent();
    }


}
