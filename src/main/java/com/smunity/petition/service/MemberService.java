package com.smunity.petition.service;

import com.smunity.petition.dto.MemberDTO;
import com.smunity.petition.entity.MemberEntity;
import com.smunity.petition.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //final 변수에 대한 생성자를 생성
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        //repository의 메서드를 호출한다. (조건. entity 객체를 넘겨주어야 한다.) JPA를 쓰기 위해서는 엔티티 객체로 소통한다.
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity); // 최근에 저장된 엔티티의 상태까지 디비에 저장하게 된다.
    }

    public MemberDTO login(MemberDTO memberDTO) {
        // db 조회 후 넘겨온 dto와 일치하는지 판단
        Optional<MemberEntity> byMemberId = memberRepository.findByMemberId(memberDTO.getMemberId());
        if(byMemberId.isPresent()){
            // 조회 결과가 있다
            MemberEntity memberEntity = byMemberId.get();
            if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){
                MemberDTO entityToDTO = MemberDTO.toMemberDTO(memberEntity);
                return entityToDTO;
            }else{
                // 비밀번호 불일치
                return null;
            }
        }else{
            // 조회 결과가 없다
            return null;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(MemberEntity memberEntity : memberEntityList){
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }

        return memberDTOList;
    }

    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if(optionalMemberEntity.isPresent()){
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        }else{
            return null;
        }
    }

    public MemberDTO updateForm(String myId) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberId(myId);
        if(optionalMemberEntity.isPresent()){
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        }else{
            return null;
        }
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO)); // insert 문이 되지 않도록 값 넣기
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
