package com.smunity.petition.domain.petition.service;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.account.repository.UserRepository;
import com.smunity.petition.domain.petition.dto.RespondRequest;
import com.smunity.petition.domain.petition.dto.RespondResponse;

import com.smunity.petition.domain.petition.entity.Respond;

import com.smunity.petition.domain.petition.repository.RespondRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import com.smunity.petition.global.common.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RespondService {
    private final RespondRepository respondRepository;
    private final UserRepository userRepository;

    public RespondResponse.respondDetail findRespondByPetitionId(Long respondId) {
        Respond respond = respondRepository.findByPetitionId(respondId);
        if (respondId == null) {
            throw new GeneralException(ErrorCode.PETITION_NOT_FOUND);
        }
        //==.orElseThrow(() -> new GeneralException(ErrorCode.PETITION_NOT_FOUND));
        return RespondResponse.respondDetail.from(respond);
    }

    public List<RespondResponse.respondList> getResponds() {
        List<Respond> responds = respondRepository.findAll();
        return RespondResponse.respondList.from(responds);
    }

    @Transactional
    public RespondResponse.respondDetail createRespond(RespondRequest.CreateRespondDTO request) {
        User user = userRepository.findByUserName("201910925").orElseThrow(() -> new GeneralException(ErrorCode._INTERNAL_SERVER_ERROR));
        Respond respond = request.toEntity();
        respond.setUser(user);
        respondRepository.save(respond);
        return RespondResponse.respondDetail.from(respond);
    }

    @Transactional
    public RespondResponse.respondDetail updateRespond(RespondRequest.UpdateDTO updateDTO, Long respondId) {
        //respondRepo에서 해당 respond를 찾는다.
        Respond respond = respondRepository.findById(respondId).orElseThrow(() -> new GeneralException(ErrorCode.RESPOND_NOT_FOUND));
        //respond 엔티티에 있는 updateRespond를 사용해서 해당 respond에 대한 내용을 수정한다.
        respond.updateRespond(updateDTO);
        Respond updated = respondRepository.save(respond);
        return RespondResponse.respondDetail.from(updated);
    }

    @Transactional
    public void deleteRespond(Long respondId) {
        respondRepository.deleteById(respondId);
    }

}
