package com.smunity.petition.domain.petition.repository;

import com.smunity.petition.domain.petition.entity.Petition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PetitionRepositoryTest {
    @Autowired
    PetitionRepository petitionRepository;

    @Test
    public void PetitionRepositoryTest() throws Exception {
        //given
        List<Petition> petitions = petitionRepository.findAll();

        //then
        for (Petition petition : petitions) {
            System.out.println(petition);
        }
    }
}
