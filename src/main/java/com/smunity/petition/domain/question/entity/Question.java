package com.smunity.petition.domain.question.entity;

import com.smunity.petition.domain.account.entity.User;
import com.smunity.petition.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "qna_question")
public class Question extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean anonymous;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User user;

    @OneToOne(mappedBy = "question", fetch = FetchType.LAZY)
    private Answer answer;

    public void update(String subject, String content, boolean anonymous) {
        this.subject = subject;
        this.content = content;
        this.anonymous = anonymous;
    }

    public void setUser(User user) {
        this.user = user;
        this.user.getQuestions().add(this);
    }
}
