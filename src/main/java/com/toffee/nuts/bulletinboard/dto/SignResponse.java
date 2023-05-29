package com.toffee.nuts.bulletinboard.dto;

import com.toffee.nuts.bulletinboard.entity.Authority;
import com.toffee.nuts.bulletinboard.entity.Member;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class SignResponse {// 응답DTO

    private Long id;

    private String account;

    private String nickname;

    private String name;

    private String email;

    private List<Authority> roles = new ArrayList<>();

    private String token;

    public SignResponse(Member member) {
        this.id = member.getId();
        this.account = member.getAccount();
        this.nickname = member.getNickname();
        this.name = member.getUsername();
        this.email = member.getEmail();
        this.roles = member.getRoles();
    }
}
