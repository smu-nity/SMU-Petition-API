package com.smunity.petition.domain.petition.controller;

import com.smunity.petition.domain.petition.dto.AgreementRequest;
import com.smunity.petition.domain.petition.dto.AgreementResponse;
import com.smunity.petition.domain.petition.dto.PetitionResponse;
import com.smunity.petition.domain.petition.service.AgreementService;
import com.smunity.petition.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/agreements")
public class AgreementController {
    private final AgreementService agreementService;

//    @GetMapping
//    public ApiResponse<List<AgreementResponse.petitionList>> getPetitionList() {
//        List<PetitionResponse.petitionList> petitionLists = petitionService.getPetitions();
//        return ApiResponse.onSuccess(petitionLists);
//    }

//    @PostMapping
//    public ApiResponse<AgreementResponse.agreementDTO> createAgreement(@RequestBody AgreementRequest request) {
//
//    }


}
