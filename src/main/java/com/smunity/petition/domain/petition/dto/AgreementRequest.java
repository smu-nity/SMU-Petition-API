package com.smunity.petition.domain.petition.dto;

import com.smunity.petition.domain.petition.entity.Agreement;
import com.smunity.petition.domain.petition.entity.Petition;
import lombok.Getter;

public class AgreementRequest {
        @Getter
        public static class CreateDTO {

            private Petition petition;

            public Agreement toEntity() {
                return Agreement.builder()
                        .petition(petition)
                        .build();
            }
        }
}
