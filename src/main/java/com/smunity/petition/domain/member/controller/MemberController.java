package com.smunity.petition.domain.member.controller;

import com.smunity.petition.domain.member.dto.MemberRequestDTO;
import com.smunity.petition.domain.member.dto.MemberResponseDTO;
import com.smunity.petition.domain.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor //매개변수로 주입
public class MemberController {
    // 생성자 주입
    private final MemberService memberService;

    //회원가입 페이지 출력 요청
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/member/update")
    public String updateForm(HttpSession session, Model model) {
        String myId = (String) session.getAttribute("loginId");
        MemberResponseDTO memberRequestDTO = memberService.updateForm(myId);
        model.addAttribute("updateMember", memberRequestDTO);
        return "update";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberRequestDTO memberRequestDTO) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberRequestDTO); //toString메서드가 호출된다.
        memberService.save(memberRequestDTO);
        //MemberService memberService = new MemberService();
        //MemberService.save(); // 잘 안쓰는 방식

        return "login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberRequestDTO memberRequestDTO, HttpSession session) {
        MemberResponseDTO loginResult = memberService.login(memberRequestDTO);

        if (loginResult != null) {
            session.setAttribute("loginId", loginResult.getMemberId());
            return "main";
        } else {
            return "login";
        }

    }

    @GetMapping("/member/")
    public String findAll(Model model) {// 데이터를 실어나르는 역할
        List<MemberResponseDTO> memberRequestDTOList = memberService.findAll();
        model.addAttribute("memberList", memberRequestDTOList); // model을 통해 데이터를 뷰 모델로 실어나른다.
        return "list";
    }

    @GetMapping("/member/{id}")
    public String findbyId(@PathVariable Long id, Model model) {
        MemberResponseDTO memberRequestDTO = memberService.findById(id);
        model.addAttribute("member", memberRequestDTO);
        return "detail";
    }

//    @PostMapping("/member/update")
//    public String update(@ModelAttribute MemberRequestDTO memberRequestDTO) {
//        memberService.update(memberRequestDTO);
//        return "redirect:/member/" + memberRequestDTO.getId();
//    }

    @GetMapping("/member/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
        return "redirect:/member/";
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 활용하여 로그아웃
        return "index";
    }
}
