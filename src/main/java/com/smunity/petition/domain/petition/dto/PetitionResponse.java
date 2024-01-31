package com.smunity.petition.domain.petition.dto;

import com.smunity.petition.domain.petition.entity.Petition;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PetitionResponse {
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class petitionDetail {
        private Long id;
        private Long userId;
        private String subject;
        private String content;
        private Integer status;
        private Integer category;
        private Boolean anonymous;
        private List<CommentResponse.commentDTO> comments;
        private RespondResponse.respondDTO respond;
        private Integer agreementCount;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
        private LocalDateTime endDate;

        public static petitionDetail from(Petition petition) {
            return petitionDetail.builder()
                    .id(petition.getId())
                    .userId(petition.getUser().getId())
                    .subject(petition.getSubject())
                    .content(petition.getContent())
                    .status(petition.getStatus())
                    .category(petition.getCategory())
                    .anonymous(petition.isAnonymous())
                    .comments(CommentResponse.commentDTO.from(petition.getComments()))
                    .agreementCount(petition.getAgreements().size())
                    .respond(petition.getRespond() != null ? RespondResponse.respondDTO.from(petition.getRespond()) : null)
                    .createdDate(petition.getCreatedDate())
                    .modifiedDate(petition.getModifiedDate())
                    .endDate(petition.getEndDate())
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class petitionList {
        private Long id;
        private Long userId;
        private String subject;
        private Integer status;
        private Integer category;
        private Boolean anonymous;

        public static petitionList from(Petition petition) {
            return petitionList.builder()
                    .id(petition.getId())
                    .userId(petition.getUser().getId())
                    .subject(petition.getSubject())
                    .status(petition.getStatus())
                    .category(petition.getCategory())
                    .anonymous(petition.isAnonymous())
                    .build();
        }

        public static List<petitionList> from(List<Petition> petitions) {
            return petitions.stream().map(petitionList::from).collect(Collectors.toList());
        }
    }
}
