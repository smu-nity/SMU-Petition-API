package com.smunity.petition.domain.petition.entity;

import com.smunity.petition.domain.account.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "petitions_petition")
public class Petition {
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
    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Column(name = "modify_date")
    private LocalDateTime modifiedDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    private int status;

    @OneToMany(mappedBy = "petition")
    private List<Agreement> agreements;

    @OneToMany(mappedBy = "petition")
    private List<Comment> comments;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "petition")
    private Respond respond;
}
