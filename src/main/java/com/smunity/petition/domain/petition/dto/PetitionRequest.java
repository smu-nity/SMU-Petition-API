package com.smunity.petition.domain.petition.dto;

import com.smunity.petition.domain.petition.entity.Petition;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PetitionRequest {

    @Getter
    public static class CreateDTO {

        private String subject;
        private String content;
        private int category;
        private boolean anonymous;

        public Petition toEntity() {
            return Petition.builder()
                    .subject(subject)
                    .content(content)
                    .category(category)
                    .anonymous(anonymous)
                    .build();
        }
    }

    @Getter
    public static class UpdateDTO {

        private String subject;
        private String content;
        private int category;

        @Override
        public String toString() {
            return "UpdateDTO{" +
                    "subject='" + subject + '\'' +
                    ", content='" + content + '\'' +
                    ", category=" + category +
                    '}';
        }
    }

}
