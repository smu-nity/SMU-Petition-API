package com.smunity.petition.repository;

import com.smunity.petition.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 데이터베이스와 작업하는 요소
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //id로 회원 정보 조회 (select * from [table] where memberId = ?)
    Optional<MemberEntity> findByMemberId(String memberId);
}
