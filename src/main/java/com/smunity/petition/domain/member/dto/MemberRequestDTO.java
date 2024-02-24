package com.smunity.petition.domain.member.dto;

import com.smunity.petition.domain.member.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor //기본생성자
@AllArgsConstructor
@ToString
public class MemberRequestDTO {
    private String memberId;
    private String memberPassword;
    private String memberName;

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .memberId(memberId)
                .memberName(memberName)
                .memberPassword(memberPassword)
                .build();
    }
}
