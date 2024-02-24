package com.smunity.petition.controller;

import com.smunity.petition.dto.MemberDTO;
import com.smunity.petition.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor //매개변수로 주입
public class MemberController {
    // 생성자 주입
    private final MemberService memberService;

    //회원가입 페이지 출력 요청
    @GetMapping("/member/save")
    public String saveForm(){
        return "save";
    }

    @GetMapping("/member/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/member/update")
    public String updateForm(HttpSession session, Model model){
        String myId = (String) session.getAttribute("loginId");
        MemberDTO memberDTO = memberService.updateForm(myId);
        model.addAttribute("updateMember", memberDTO);
        return "update";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO); //toString메서드가 호출된다.
        memberService.save(memberDTO);
        //MemberService memberService = new MemberService();
        //MemberService.save(); // 잘 안쓰는 방식

        return "login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        MemberDTO loginResult = memberService.login(memberDTO);

        if(loginResult != null){
            session.setAttribute("loginId", loginResult.getMemberId());
            return "main";
        }else{
            return "login";
        }

    }

    @GetMapping("/member/")
    public String findAll(Model model){// 데이터를 실어나르는 역할
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList); // model을 통해 데이터를 뷰 모델로 실어나른다.
        return "list";
    }

    @GetMapping("/member/{id}")
    public String findbyId(@PathVariable Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }

    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        memberService.update(memberDTO);
        return "redirect:/member/" + memberDTO.getId();
    }

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
