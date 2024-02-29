package com.smunity.petition.domain.petition.controller;

import com.smunity.petition.domain.petition.dto.RespondRequest;
import com.smunity.petition.domain.petition.dto.RespondResponse;
import com.smunity.petition.domain.petition.service.RespondService;
import com.smunity.petition.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/responds")
public class RespondController {
    private final RespondService respondService;

    @GetMapping("/{respondId}")
    public ApiResponse<RespondResponse.respondDetail> getRespondDetail(@PathVariable Long respondId) {
        RespondResponse.respondDetail respondDetail = respondService.findRespondByPetitionId(respondId);
        return ApiResponse.onSuccess(respondDetail);
    }

    @GetMapping
    public ApiResponse<List<RespondResponse.respondList>> getRespondList() {
        List<RespondResponse.respondList> respondLists = respondService.getResponds();
        return ApiResponse.onSuccess(respondLists);
    }

    @PostMapping
    public ApiResponse<RespondResponse.respondDetail> createRespond(@RequestBody RespondRequest.CreateRespondDTO request) {
        return ApiResponse.created(respondService.createRespond(request));
    }

    @PatchMapping("/{respondId}")
    public ApiResponse<RespondResponse.respondDetail> updateRespond(@PathVariable Long respondId, @RequestBody RespondRequest.UpdateDTO updateDTO) {
        RespondResponse.respondDetail respondDetail = respondService.updateRespond(updateDTO, respondId);
        return ApiResponse.created(respondDetail);
    }

    @DeleteMapping("/{respondId}")
    public ApiResponse<Object> deleteRespond(@PathVariable Long respondId) {
        respondService.deleteRespond(respondId);
        return ApiResponse.noContent();
    }
}
