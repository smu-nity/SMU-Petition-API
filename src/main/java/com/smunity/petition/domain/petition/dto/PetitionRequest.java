package com.smunity.petition.domain.petition.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
public class PetitionRequest {
    private String subject;

    private String content;

    private int category;

    private boolean anonymous;

}
