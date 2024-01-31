package com.smunity.petition.domain.petition.dto;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.petition.entity.Comment;
import com.smunity.petition.domain.petition.entity.Respond;

import java.time.LocalDateTime;

public class RespondResponse {

    public static class respondDTO{
        private String content;

        private Long userId;

        private LocalDateTime createdDate;

        private LocalDateTime modifiedDate;

        public respondDTO(Respond respond, User user){
            this.content = respond.getContent();
            this.userId = user.getId();
            this.createdDate = respond.getCreatedDate();
            this.modifiedDate = respond.getModifiedDate();
        }
    }
}
