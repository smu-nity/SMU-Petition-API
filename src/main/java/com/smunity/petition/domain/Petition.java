package com.smunity.petition.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "petition")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Petition {

    @Id @GeneratedValue
    @Column(name = "petition_id")
    private Long petitionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User user;

    @Column(length = 200)
    private String subject;

    private String content;

    private int category;

    private boolean anonymous;
    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    private int status;

}
