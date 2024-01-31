package com.smunity.petition.domain.petition.dto;

import com.smunity.petition.domain.petition.entity.Petition;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class PetitionResponse {

    @Getter
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

        private Boolean isVoted;

        private Integer agreementCount;

        private LocalDateTime createdDate;

        private LocalDateTime modifiedDate;

        private LocalDateTime endDate;

        public petitionDetail(Petition petition,
                                Long userId,
                                Boolean isVoted,
                                Integer agreementCount,
                                List<CommentResponse.commentDTO> comments,
                                RespondResponse.respondDTO respond
        ) {
            this.subject = petition.getSubject();
            this.content = petition.getContent();
            this.status = petition.getStatus();
            this.category = petition.getCategory();
            this.anonymous = petition.isAnonymous();
            this.createdDate = petition.getCreatedDate();
            this.modifiedDate = petition.getModifiedDate();
            this.endDate = petition.getEndDate();
            this.userId = userId;
            this.isVoted = isVoted;
            this.agreementCount = agreementCount;
            this.comments = comments;
            this.respond = respond;
        }
    }

    @Getter
    public static class petitionList{

        private Long id;

        private Long userId;

        private String subject;

        private Integer status;

        private Integer category;

        private Boolean anonymous;

        public petitionList(Petition petition, Long userId){

            this.id = petition.getId();
            this.subject = petition.getSubject();
            this.status = petition.getStatus();
            this.category = petition.getCategory();
            this.anonymous = petition.isAnonymous();
            this.userId = userId;

        }
    }

}
