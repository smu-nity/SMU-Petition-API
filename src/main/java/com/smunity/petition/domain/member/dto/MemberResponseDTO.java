package com.smunity.petition.domain.member.dto;

import com.smunity.petition.domain.member.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor //기본생성자
@AllArgsConstructor
@ToString
public class MemberResponseDTO {
    private Long id;
    private String memberId;
    private String memberPassword;
    private String memberName;

    public static MemberResponseDTO from(MemberEntity memberEntity) {
        return MemberResponseDTO.builder()
                .id(memberEntity.getId())
                .memberId(memberEntity.getMemberId())
                .memberName(memberEntity.getMemberName())
                .memberPassword(memberEntity.getMemberPassword())
                .build();
    }
}
