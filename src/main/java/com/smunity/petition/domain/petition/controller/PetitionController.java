package com.smunity.petition.domain.petition.controller;

import com.smunity.petition.domain.petition.dto.PetitionResponse;
import com.smunity.petition.domain.petition.service.PetitionService;
import com.smunity.petition.global.common.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/petitions")
public class PetitionController {

    private final PetitionService petitionService;

    @GetMapping("/{id}")
    public ApiResponse<PetitionResponse.petitionDetail> getPetitionDetail(@PathVariable Long id) {
        PetitionResponse.petitionDetail petitionDetail = petitionService.getPetitionDetail(id);
        return ApiResponse.onSuccess(petitionDetail);
    }

    @GetMapping
    public ApiResponse<List<PetitionResponse.petitionList>> getPetitionList() {
        List<PetitionResponse.petitionList> petitionLists = petitionService.getPetitionList();
        return ApiResponse.onSuccess(petitionLists);
    }
}
