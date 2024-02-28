package com.smunity.petition.domain.account.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Table(name = "accounts_department")
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "college", nullable = false)
    private String college;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "department")
    private List<User> users;
}
