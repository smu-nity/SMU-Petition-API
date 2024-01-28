package com.smunity.petition.domain.question.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "qna_question")
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean anonymous;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "author_id")
    //private User user;

    @Column(nullable = false)
    private Timestamp create_date;

    @Column(nullable = false)
    private Timestamp modify_date;

    @OneToOne(mappedBy = "question", fetch = FetchType.LAZY)
    private Answer answer;

    public void setSubject(String subject) {
        subject = subject;
    }

    public void setContent(String content) {
        content = content;
    }

    public void setAnonymous(boolean anonymous) {
        anonymous = anonymous;
    }
}
