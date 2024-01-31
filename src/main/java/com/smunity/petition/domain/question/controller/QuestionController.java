package com.smunity.petition.domain.question.controller;

import com.smunity.petition.domain.question.dto.QuestionDto;
import com.smunity.petition.domain.question.dto.QuestionListDto;
import com.smunity.petition.domain.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public List<QuestionListDto> list() {
        return questionService.getQuestion();
    }
    @GetMapping("/{id}")
    public QuestionDto read(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }
}