package com.smunity.petition.domain.petition.service;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.account.repository.UserRepository;
import com.smunity.petition.domain.petition.dto.CommentResponse;
import com.smunity.petition.domain.petition.dto.PetitionResponse;
import com.smunity.petition.domain.petition.dto.RespondResponse;
import com.smunity.petition.domain.petition.entity.Agreement;
import com.smunity.petition.domain.petition.entity.Comment;
import com.smunity.petition.domain.petition.entity.Petition;
import com.smunity.petition.domain.petition.entity.Respond;
import com.smunity.petition.domain.petition.repository.AgreementRepository;
import com.smunity.petition.domain.petition.repository.CommentRepository;
import com.smunity.petition.domain.petition.repository.PetitionRepository;
import com.smunity.petition.domain.petition.repository.RespondRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.smunity.petition.domain.petition.dto.PetitionResponse.*;

@Service
@RequiredArgsConstructor
public class PetitionService {

    private final PetitionRepository petitionRepository;
    private final CommentRepository commentRepository;
    private final AgreementRepository agreementRepository;
    private final RespondRepository respondRepository;
    private final UserRepository userRepository;

    public PetitionResponse.petitionDetail getPetitionDetail(Long petitionId) {

        Petition petition = petitionRepository.findByPetitionId(petitionId);
        User user = userRepository.findByuserId(petition.getAuthor_id());
        List<CommentResponse.commentDTO> comments = commentRepository.findAllByPetitionId(petitionId);
        RespondResponse.respondDTO respond = respondRepository.findByPetitionId(petitionId);
        Agreement agreement = agreementRepository.findByPetitionIdUAndUser_id(petitionId, petition.getAuthor_id());
        List<Agreement> agreements = agreementRepository.findAllByPetitionId(petitionId);

        boolean isVoted = false;

        if (agreement == null) {
            isVoted = false;
        } else {
            isVoted = true;
        }

        int agreementCount = countAgreement(agreements);


        PetitionResponse.petitionDetail petitionDetail = new petitionDetail(petition,
                user.getId(),
                isVoted,
                agreementCount,
                comments,
                respond);

        return petitionDetail;
    }


    private int countAgreement(List<Agreement> agreements) {

        int count = 0;

        for ( Agreement agreement : agreements ){
            count++;
        }

        return count;
    }

    public List<PetitionResponse.petitionList> getPetitionList(){

        List<Petition> petitions = petitionRepository.findAll();
        List<PetitionResponse.petitionList> petitionLists = new ArrayList<>();

        for (Petition petition : petitions){
            PetitionResponse.petitionList petitionListDTO = new PetitionResponse.petitionList(petition,petition.getAuthor_id());
            petitionLists.add(petitionListDTO);
        }

        return petitionLists;

    }

}
