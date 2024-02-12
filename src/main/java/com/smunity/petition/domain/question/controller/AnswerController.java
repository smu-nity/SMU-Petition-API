package com.smunity.petition.domain.question.controller;

import com.smunity.petition.domain.question.dto.AnswerDto;
import com.smunity.petition.domain.question.dto.AnswerRequestDto;
import com.smunity.petition.domain.question.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/answer")
public class AnswerController {
    private final AnswerService answerService;

    @GetMapping("/{question_id}")
    public AnswerDto read(@PathVariable Long question_id) {
        return answerService.getAnswerByQuestionId(question_id);
    }

    @PostMapping("/{question_id}")
    public AnswerDto create(@RequestBody AnswerRequestDto answer,
                         @PathVariable Long question_id) {
        return answerService.save(answer, answer.getQuestion_id());
    }

    @PatchMapping("/{answer_id}")
    public AnswerRequestDto update(@RequestBody AnswerRequestDto answer,
                         @PathVariable Long answer_id){
        return answerService.update(answer_id, answer);
    }
    @DeleteMapping("/{answer_id}")
    public AnswerDto delete(@PathVariable Long answer_id) {
        return answerService.delete(answer_id);
    }
}
