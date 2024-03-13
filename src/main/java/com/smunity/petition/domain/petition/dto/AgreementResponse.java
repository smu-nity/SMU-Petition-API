package com.smunity.petition.domain.petition.dto;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.petition.entity.Agreement;
import com.smunity.petition.domain.petition.entity.Comment;
import com.smunity.petition.domain.petition.entity.Petition;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AgreementResponse {
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class agreementDTO {
        private Petition petition;
        private Long id;
        private Long userId;
        private User user;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;

        public static AgreementResponse.agreementDTO from(Agreement agreement) {
            return AgreementResponse.agreementDTO.builder()
                    .petition(agreement.getPetition())
                    .userId(agreement.getUser().getId())
                    .user(agreement.getUser())
                    .createdDate(agreement.getCreateDate())
                    .modifiedDate(agreement.getModifyDate())
                    .build();
        }

        public static List<CommentResponse.commentDTO> from(List<Comment> comments) {
            return comments.stream().map(CommentResponse.commentDTO::from).collect(Collectors.toList());
        }
    }
}


