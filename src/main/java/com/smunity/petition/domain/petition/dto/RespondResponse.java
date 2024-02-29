package com.smunity.petition.domain.petition.dto;

import com.smunity.petition.domain.petition.entity.Petition;
import com.smunity.petition.domain.petition.entity.Respond;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RespondResponse {
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class respondDetail {
        private Long id;
        private Petition petition;
        private Long userId;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;

        public static respondDetail from(Respond respond) {
            return respondDetail.builder()
                    .petition(respond.getPetition())
                    .userId(respond.getUser().getId())
                    .createdDate(respond.getCreateDate())
                    .modifiedDate(respond.getModifyDate())
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class respondList {
        private Long id;
        private Long userId;
        private Petition petition;


        public static respondList from(Respond respond) {
            return respondList.builder()
                    .id(respond.getId())
                    .userId(respond.getUser().getId())
                    .petition(respond.getPetition())
                    .build();
        }
        public static List<respondList> from(List<Respond> responds) {
            return responds.stream().map(respondList::from).collect(Collectors.toList());
        }
    }


}
