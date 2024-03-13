package com.smunity.petition.domain.petition.service;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.account.repository.UserRepository;
import com.smunity.petition.domain.petition.dto.AgreementRequest;
import com.smunity.petition.domain.petition.dto.AgreementResponse;
import com.smunity.petition.domain.petition.entity.Agreement;
import com.smunity.petition.domain.petition.repository.AgreementRepository;
import com.smunity.petition.global.common.code.status.ErrorCode;
import com.smunity.petition.global.common.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AgreementService {
    private final AgreementRepository agreementRepository;
    private final UserRepository userRepository;

//    @Transactional
//    public AgreementResponse.agreementDTO createAgreement(AgreementRequest.CreateDTO request) {
//        User user = userRepository.findByUserName("201911019").orElseThrow(() -> new GeneralException(ErrorCode._INTERNAL_SERVER_ERROR));
//        Agreement agreement = request.toEntity();
//    }


}
