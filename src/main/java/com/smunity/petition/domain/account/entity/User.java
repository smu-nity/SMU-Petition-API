package com.smunity.petition.domain.account.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Entity
@Table(name = "auth_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "last_login", nullable = false)
    private LocalDateTime lastLogin;

    @Column(name = "is_superuser", nullable = false)
    private boolean isSuperuser;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "is_staff", nullable = false)
    private boolean isStaff;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "last_login", nullable = false)
    private LocalDateTime dateJoined;

}
