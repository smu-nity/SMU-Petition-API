package com.smunity.petition.domain.question.repository;

import com.smunity.petition.domain.question.entity.Answer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class AnswerRepositoryTest {
    @Autowired
    AnswerRepository answerRepository;

    @Test
    public void AnswerRepositoryTest() throws Exception {
        //given
        List<Answer> answers = answerRepository.findAll();

        //then
        for (Answer answer : answers)
            System.out.println(answer);
    }
}
