package com.smunity.petition.domain.question.entity;


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
@Table(name = "qna_answer")
public class Answer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String content;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "author_id")
    //private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;



    public void setContent(String content) {
        content=content;
    }
}