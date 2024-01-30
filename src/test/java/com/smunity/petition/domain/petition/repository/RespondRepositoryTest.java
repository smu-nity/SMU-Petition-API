package com.smunity.petition.domain.petition.repository;

import com.smunity.petition.domain.petition.entity.Respond;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RespondRepositoryTest {
    @Autowired
    RespondRepository respondRepository;

    @Test
    public void RespondRepositoryTest() throws Exception {
        //given
        List<Respond> responds = respondRepository.findAll();

        //then
        for (Respond respond : responds) {
            System.out.println(respond);
        }
    }
}
