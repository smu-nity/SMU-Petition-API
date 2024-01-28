package com.smunity.petition.domain.petition.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "petitions_petition")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Petition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long author_id;

    //TODO User 테이블 생성 후 연결
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "author_id")
//    private User user;

    @Column(length = 200)
    private String subject;

    private String content;

    private int category;

    private boolean anonymous;
    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Column(name = "modify_date")
    private LocalDateTime modifiedDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    private int status;
}
