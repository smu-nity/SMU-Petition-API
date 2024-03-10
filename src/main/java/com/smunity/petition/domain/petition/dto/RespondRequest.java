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
        private Long petitionId;
        private String content;
        //절대 엔티티 자체를 넣지 말자

        public Respond toEntity() {
            return Respond.builder()
                    .petition(new Petition(petitionId))
                    .content(content)
                    .build();
        }
    }
    @Getter
    public static class UpdateDTO {
        private String content;
    }
}
