package com.smunity.petition.domain.petition.dto;

import com.smunity.petition.domain.petition.entity.Respond;
import lombok.*;

import java.time.LocalDateTime;

public class RespondResponse {
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class respondDTO {
        private String content;
        private Long userId;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;

        public static respondDTO from(Respond respond) {
            return respondDTO.builder()
                    .content(respond.getContent())
                    .userId(respond.getUser().getId())
                    .createdDate(respond.getCreatedDate())
                    .modifiedDate(respond.getModifiedDate())
                    .build();
        }
    }
}
