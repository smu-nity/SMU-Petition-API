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

    // @PostMapping("/{question_id}")
    // public ApiResponse<AnswerResponseDto> createAnswer(
    //        @PathVariable Long questionId,
    //        @RequestBody AnswerRequestDto answerRequestDto) {
    //    return ApiResponse.onSuccess(answerService.createAnswer);
    //}

    @GetMapping("/{questionId}")
    public ApiResponse<AnswerResponseDto> getAnswer(@PathVariable Long questionId){
        AnswerResponseDto answer = answerService.getAnswer(questionId);
        return ApiResponse.onSuccess(answer);
    }

    @PutMapping("/{answerId}")
    public ApiResponse<AnswerResponseDto> updateAnswer(
            @PathVariable Long answerId,
            @RequestBody AnswerRequestDto answerRequestDto){
        return ApiResponse.onSuccess(answerService.updateAnswer(answerId, answerRequestDto));
    }

    @DeleteMapping("/{answerId}")
    public ApiResponse<Void> deleteAnswer(
            @PathVariable Long answerId){
        answerService.deleteAnswer(answerId);
        return ApiResponse.noContent();
    }

}
