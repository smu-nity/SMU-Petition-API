package com.smunity.petition.domain.petition.entity;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "petitions_petition")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Petition extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User user;

    @Column(length = 200)
    private String subject;

    private String content;

    private int category;

    private boolean anonymous;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    private int status;
}
