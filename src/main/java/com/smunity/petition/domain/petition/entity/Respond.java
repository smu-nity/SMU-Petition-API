package com.smunity.petition.domain.petition.entity;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.domain.petition.dto.RespondRequest;
import com.smunity.petition.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "petitions_answer")
public class Respond extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //학생회 측
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petition_id")
    Petition petition;


    private String content;

    public void setUser(User user) {
        this.user = user;
        this.user.getResponds().add(this);
    }

    public void setPetition(Petition petition) {
        this.petition = petition;
    }

    public void updateRespond(RespondRequest.UpdateDTO updateDTO) {
        this.content = updateDTO.getContent();
    }

}
