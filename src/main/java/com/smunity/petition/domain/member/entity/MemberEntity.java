package com.smunity.petition.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;

// 일종의 테이블 역할 이고브에서 DAO 역할과 비슷
// 데이터 베이스 테이블을 일종의 자바 객체 처럼 사용하게 해주는 것이 JPA의 큰 특징이다.
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "member_table")
public class MemberEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto.increment
    private Long id;

    @Column(unique = true) // unique 제약 조건 추가
    private String memberId;

    @Column
    private String memberPassword;

    @Column
    private String memberName;
}
