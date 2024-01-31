package com.smunity.petition.domain.petition.dto;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.petition.entity.Comment;

import java.time.LocalDateTime;

public class CommentResponse {

    public static class commentDTO{

        private String content;

        private Long userId;

        private LocalDateTime createdDate;

        private LocalDateTime modifiedDate;

        public commentDTO(Comment comment, User user){
            this.content = comment.getContent();
            this.userId = user.getId();
            this.createdDate = comment.getCreatedDate();
            this.modifiedDate = comment.getModifiedDate();
        }
    }
}
