package com.toffee.nuts.bulletinboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignRequest {// 응답DTO

    private Long id;
    private String account;

    private String password;

    private String nickname;

    private String username;

    private String email;
}
