package com.smunity.petition.domain.account.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Table(name = "accounts_year")
@Entity
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year", nullable = false)
    private String year;

    @Column(name = "major_i")
    private int majorI;

    @Column(name = "major_s")
    private int majorS;

    @Column(name = "culture")
    private int culture;

    @Column(name = "culture_cnt")
    private int cultureCnt;

    @Column(name = "all_score")
    private int all;

    @OneToMany(mappedBy = "year")
    private List<User> users;
}
