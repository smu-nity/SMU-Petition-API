package com.smunity.petition.domain.petition.repository;

import com.smunity.petition.domain.petition.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    public void CommentRepositoryTest() throws Exception {
        //given
        List<Comment> comments = commentRepository.findAll();

        //then
        for (Comment comment : comments) {
            System.out.println(comment);
        }
    }
}
