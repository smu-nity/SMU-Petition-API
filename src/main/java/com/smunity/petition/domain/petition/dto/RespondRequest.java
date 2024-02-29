package com.smunity.petition.domain.petition.dto;

import com.smunity.petition.domain.petition.entity.Petition;
import com.smunity.petition.domain.petition.entity.Respond;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RespondRequest {
    @Getter
    public static class CreateRespondDTO {
        private Petition petition;
        private String content;


        public Respond toEntity() {
            return Respond.builder()
                    .petition(petition)
                    .content(content)
                    .build();
        }
    }
    @Getter
    public static class UpdateDTO {
        private String content;
    }
}
