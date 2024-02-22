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
    public PetitionResponse.petitionDetail createPetition(@RequestBody PetitionRequest.CreateDTO request) {
        return petitionService.createPetition(request);
    }

    @PatchMapping("/{petitionId}")
    public ApiResponse<PetitionResponse.petitionDetail> updatePetition(@PathVariable(name = "petitionId") Long petitionId, PetitionRequest.UpdateDTO updateDTO){
        PetitionResponse.petitionDetail petitionDetail = petitionService.updatePetition(updateDTO,petitionId);
        return ApiResponse.onSuccess(petitionDetail);
    }

    @DeleteMapping("/{petitionId}")
    public ApiResponse<Object> deletePetition(@PathVariable(name = "petitionId") Long petitionId){
        petitionService.deletePetition(petitionId);
        return ApiResponse.onSuccess("청원 게시글이 삭제되었습니다.");
    }
}
