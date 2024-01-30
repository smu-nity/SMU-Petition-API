package com.smunity.petition.domain.petition.repository;

import com.smunity.petition.domain.petition.entity.Agreement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AgreementRepositoryTest {
    @Autowired
    AgreementRepository agreementRepository;

    @Test
    public void AgreementRepositoryTest() throws Exception {
        //given
        List<Agreement> agreements = agreementRepository.findAll();

        //then
        for (Agreement agreement : agreements) {
            System.out.println(agreement);
        }
    }
}
