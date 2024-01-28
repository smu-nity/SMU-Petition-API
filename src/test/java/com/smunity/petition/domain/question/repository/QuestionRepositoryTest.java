package com.smunity.petition.domain.question.repository;

import com.smunity.petition.domain.question.entity.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class QuestionRepositoryTest {
    @Autowired
    QuestionRepository questionRepository;

    @Test
    public void QuestionRepositoryTest() throws Exception {
        //given
        List<Question> questions = questionRepository.findAll();

        //then
        for (Question question : questions)
            System.out.println(question);
    }
}
