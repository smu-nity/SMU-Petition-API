package com.smunity.petition.petitions.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Petition {
    @Id @GeneratedValue
    @Column(name = "petition_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User user;

    private String subject;

    private String text;

    private int category;

    private int anonymous; //0,1로 구분?
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private LocalDateTime endDate;
    private int status;



}
