package com.toffee.nuts.bulletinboard.service;


import com.toffee.nuts.bulletinboard.dto.SignRequest;
import com.toffee.nuts.bulletinboard.dto.SignResponse;
import com.toffee.nuts.bulletinboard.entity.Authority;
import com.toffee.nuts.bulletinboard.entity.Member;
import com.toffee.nuts.bulletinboard.repository.MemberRepository;
import com.toffee.nuts.bulletinboard.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
public class SignService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    public SignResponse login(SignRequest request) throws Exception {




        Member member = memberRepository.findByAccount(request.getAccount()).orElseThrow(() -> new
                BadCredentialsException("잘못된 계정정보입니다."));


        System.out.println("===============");
        System.out.println("member password" + member.getPassword());
        System.out.println("===============");


        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new  BadCredentialsException("잘못된 계정정보입니다.");
        }

        return SignResponse.builder()
                .id(member.getId())
                .account(member.getAccount())
                .name(member.getUsername())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .roles(member.getRoles())
                .token(jwtTokenProvider.createToken(member.getAccount(), member.getRoles()))
                        .build();
    }

    public boolean register(SignRequest request) throws Exception {
        try {
            Member member = Member.builder()
                    .account(request.getAccount())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .username(request.getUsername())
                    .nickname(request.getNickname())
                    .email(request.getEmail())
                    .build();

            member.setRoles(Collections.singletonList(Authority.builder().name("ROLE_USER").build()));
            memberRepository.save(member);
        }   catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }


    public SignResponse getMember(String account) throws Exception {
        Member member = memberRepository.findByAccount(account)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new SignResponse(member);
    }



}
