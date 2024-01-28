package com.smunity.petition.domain.petition.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "petitions_answer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Respond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long author_id;

    //TODO User 테이블 생성 후 연결
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "author_id")
//    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petition_id")
    private Petition petition;

    private String content;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Column(name = "modify_date")
    private LocalDateTime modifiedDate;
}
