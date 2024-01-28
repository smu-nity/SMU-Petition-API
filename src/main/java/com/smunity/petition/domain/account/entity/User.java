package com.smunity.petition.domain.account.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

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

    public void setProfile(Profile profile) {
        profile = profile;
    }
}
