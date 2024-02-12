package com.smunity.petition.domain.petition.controller;

import com.smunity.petition.domain.petition.dto.PetitionRequest;
import com.smunity.petition.domain.petition.dto.PetitionResponse;
import com.smunity.petition.domain.petition.service.PetitionService;
import com.smunity.petition.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/petitions")
public class PetitionController {
    private final PetitionService petitionService;

    @GetMapping
    public ApiResponse<List<PetitionResponse.petitionList>> getPetitionList() {
        List<PetitionResponse.petitionList> petitionLists = petitionService.getPetitions();
        return ApiResponse.onSuccess(petitionLists);
    }

    @GetMapping("/{id}")
    public ApiResponse<PetitionResponse.petitionDetail> getPetitionDetail(@PathVariable Long id) {
        PetitionResponse.petitionDetail petitionDetail = petitionService.getPetitionById(id);
        return ApiResponse.onSuccess(petitionDetail);
    }

    @PostMapping
    public PetitionResponse.petitionDetail createPetition(@RequestBody PetitionRequest request) {
        return petitionService.createPetition(request);
    }
}
