package com.smunity.petition.domain.account.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smunity.petition.domain.question.entity.Answer;
import com.smunity.petition.domain.question.entity.Question;
import com.smunity.petition.domain.petition.entity.Petition;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "auth_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String userName; // 학번

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "is_superuser", nullable = false)
    @ColumnDefault("false")
    private Boolean isSuperUser;

    @Column(name = "is_staff", nullable = false)
    @ColumnDefault("false")
    private Boolean isStaff;

    @Column(name = "is_active", nullable = false)
    @ColumnDefault("true")
    private Boolean isActive;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "date_joined")
    @CreatedDate
    private LocalDateTime dateJoined;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Profile profile;

    @OneToMany(mappedBy = "user")
    private List<Question> questions;

    @OneToMany(mappedBy = "user")
    private List<Answer> answers;
  
    private List<Petition> petitions;

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
