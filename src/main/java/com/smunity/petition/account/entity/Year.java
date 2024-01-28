package com.smunity.petition.account.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "major_i", nullable = false)
    private int majorI;

    @Column(name = "major_s", nullable = false)
    private int majorS;

    @Column(name = "culture", nullable = false)
    private int culture;

    @Column(name = "culture_cnt", nullable = false)
    private int cultureCnt;

    @Column(name = "all", nullable = false)
    private int all;

    @OneToMany(mappedBy = "year")
    private List<Profile> profiles;
}
