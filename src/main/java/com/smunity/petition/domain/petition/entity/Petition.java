package com.smunity.petition.domain.petition.entity;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.petition.dto.PetitionRequest;
import com.smunity.petition.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "petitions_petition")
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

    @OneToMany(mappedBy = "petition")
    private List<Agreement> agreements;

    @OneToMany(mappedBy = "petition")
    private List<Comment> comments;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "petition")
    private Respond respond;

    public void setUser(User user) {
        this.user = user;
        this.user.getPetitions().add(this);
    }

    public void updatePetition(PetitionRequest.UpdateDTO updateDTO){
        this.subject = updateDTO.getSubject();
        this.content = updateDTO.getContent();
        this.category = updateDTO.getCategory();
    }
}
