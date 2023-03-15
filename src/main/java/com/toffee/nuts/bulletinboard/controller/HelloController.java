package com.toffee.nuts.bulletinboard.controller;

import com.toffee.nuts.bulletinboard.entity.Member;
import com.toffee.nuts.bulletinboard.repository.MemberRepository;
import com.toffee.nuts.bulletinboard.util.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/member")
    public @ResponseBody String user(Model model) {
        return "user";
    }


    @GetMapping("/fail")
    public @ResponseBody String fail(Model model) {
        return "fail";
    }

    @GetMapping("/join")
    public String join(Model model) {
        return "join";
    }

    @GetMapping("/login")
    public String login(Model model) {
        // 이전페이지 URL 추출
       // String referrer = request.getHeader("Referer");
       // request.getSession().setAttribute("prevPage", referrer);
        return "login";
    }

    @PostMapping("/joinProc")
    public String joinProc(Member member) {
        String rawPassword = member.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        member.setPassword(encPassword);
        member.setUserRole(UserRole.ROLE_MEMBER);
        memberRepository.save(member);
        return "redirect:/";
    }

}
