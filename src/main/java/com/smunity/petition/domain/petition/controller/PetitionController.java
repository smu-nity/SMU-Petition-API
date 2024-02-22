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

    @GetMapping("/{petitionId}")
    public ApiResponse<PetitionResponse.petitionDetail> getPetitionDetail(@PathVariable Long petitionId) {
        PetitionResponse.petitionDetail petitionDetail = petitionService.getPetitionById(petitionId);
        return ApiResponse.onSuccess(petitionDetail);
    }

    @PostMapping
    public ApiResponse<PetitionResponse.petitionDetail> createPetition(@RequestBody PetitionRequest.CreateDTO request) {
        return ApiResponse.created(petitionService.createPetition(request));
    }

    @PatchMapping("/{petitionId}")
    public ApiResponse<PetitionResponse.petitionDetail> updatePetition(@PathVariable Long petitionId, @RequestBody PetitionRequest.UpdateDTO updateDTO) {
        PetitionResponse.petitionDetail petitionDetail = petitionService.updatePetition(updateDTO, petitionId);
        return ApiResponse.created(petitionDetail);
    }

    @DeleteMapping("/{petitionId}")
    public ApiResponse<Object> deletePetition(@PathVariable Long petitionId) {
        petitionService.deletePetition(petitionId);
        return ApiResponse.noContent();
    }
}
