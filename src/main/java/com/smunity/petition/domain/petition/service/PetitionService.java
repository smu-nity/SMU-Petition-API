package com.smunity.petition.domain.petition.service;

import com.smunity.petition.domain.petition.dto.PetitionResponse;
import com.smunity.petition.domain.petition.entity.Petition;
import com.smunity.petition.domain.petition.repository.PetitionRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import com.smunity.petition.global.common.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PetitionService {
    private final PetitionRepository petitionRepository;

    public PetitionResponse.petitionDetail getPetitionById(Long petitionId) {
        Petition petition = petitionRepository.findById(petitionId).orElseThrow(() -> new GeneralException(ErrorCode.PETITION_NOT_FOUND));
        return PetitionResponse.petitionDetail.from(petition);
    }

    public List<PetitionResponse.petitionList> getPetitions() {
        List<Petition> petitions = petitionRepository.findAll();
        return PetitionResponse.petitionList.from(petitions);
    }
}
