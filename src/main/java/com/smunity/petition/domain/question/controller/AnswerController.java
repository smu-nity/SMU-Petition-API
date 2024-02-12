package com.smunity.petition.domain.question.controller;

import com.smunity.petition.domain.question.dto.AnswerRequestDto;
import com.smunity.petition.domain.question.dto.AnswerResponseDto;
import com.smunity.petition.domain.question.service.AnswerService;
import com.smunity.petition.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/answers")
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("/{questionId}")
    public ApiResponse<AnswerResponseDto> createAnswer(
            @PathVariable Long questionId,
            @RequestBody AnswerRequestDto answerRequestDto) {
        return ApiResponse.onSuccess(answerService.createAnswer(questionId, answerRequestDto));
    }

    @GetMapping("/{answerId}")
    public ApiResponse<AnswerResponseDto> getAnswer(@PathVariable Long answerId) {
        AnswerResponseDto answer = answerService.getAnswer(answerId);
        return ApiResponse.onSuccess(answer);
    }

    @PatchMapping("/{answerId}")
    public ApiResponse<AnswerResponseDto> updateAnswer(
            @PathVariable Long answerId,
            @RequestBody AnswerRequestDto answerRequestDto) {
        return ApiResponse.onSuccess(answerService.updateAnswer(answerId, answerRequestDto));
    }

    @DeleteMapping("/{answerId}")
    public ApiResponse<Void> deleteAnswer(
            @PathVariable Long answerId) {
        answerService.deleteAnswer(answerId);
        return ApiResponse.noContent();
    }
}
