package com.smunity.petition.domain.petition.dto;

import com.smunity.petition.domain.petition.entity.Comment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CommentResponse {
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class commentDTO {
        private String content;
        private Long userId;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;

        public static commentDTO from(Comment comment) {
            return commentDTO.builder()
                    .content(comment.getContent())
                    .userId(comment.getUser().getId())
                    .createdDate(comment.getCreateDate())
                    .modifiedDate(comment.getModifyDate())
                    .build();
        }

        public static List<commentDTO> from(List<Comment> comments) {
            return comments.stream().map(commentDTO::from).collect(Collectors.toList());
        }
    }
}
