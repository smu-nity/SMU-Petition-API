package com.smunity.petition.domain.account.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smunity.petition.domain.petition.entity.Petition;
import com.smunity.petition.domain.question.entity.Answer;
import com.smunity.petition.domain.question.entity.Question;
import com.smunity.petition.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "auth_user")
@Entity
public class User extends BaseEntity implements UserDetails {
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

//    @Column(name = "is_superuser", nullable = false)
//    @ColumnDefault("false")
//    private Boolean isSuperUser;
//
//    @Column(name = "is_staff", nullable = false)
//    @ColumnDefault("false")
//    private Boolean isStaff;
//
//    @Column(name = "is_active", nullable = false)
//    @ColumnDefault("true")
//    private Boolean isActive;

//    @Column(name = "last_login")
//    private LocalDateTime lastLogin;

//    @Column(name = "date_joined")
//    @CreatedDate
//    private LocalDateTime dateJoined;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Profile profile;

    @OneToMany(mappedBy = "user")
    private List<Question> questions;

    @OneToMany(mappedBy = "user")
    private List<Answer> answers;

    @OneToMany(mappedBy = "user")
    private List<Petition> petitions;

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @ElementCollection
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles
                .stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername() {
        return this.userName;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
