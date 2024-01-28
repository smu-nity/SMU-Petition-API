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
@Table(name = "qna_question")
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Boolean anonymous;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "author_id")
    //private User user;

    @OneToOne(mappedBy = "question", fetch = FetchType.LAZY)
    private Answer answer;

    public boolean isAnonymous() {
        return this.anonymous;
    }

    public void setTitle(String title){
        title=title;
    }

    public void setContent(String content){
        content=content;
    }

    public void setAnonymous(Boolean anonymous)
    {
        anonymous=anonymous;
    }

}

