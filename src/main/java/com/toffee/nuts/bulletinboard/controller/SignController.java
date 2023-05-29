package com.toffee.nuts.bulletinboard.controller;


import com.toffee.nuts.bulletinboard.dto.SignRequest;
import com.toffee.nuts.bulletinboard.dto.SignResponse;
import com.toffee.nuts.bulletinboard.repository.MemberRepository;
import com.toffee.nuts.bulletinboard.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SignController {

    private final MemberRepository memberRepository;
    private final SignService signService;

    @PostMapping(value = "/login")
    public ResponseEntity<SignResponse> signIn(@RequestBody SignRequest request) throws Exception {
        System.out.println("===============");
        System.out.println("login start");
        System.out.println("===============");

        return new ResponseEntity<>(signService.login(request), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Boolean> signUp(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(signService.register(request), HttpStatus.OK);
    }

    @GetMapping("/user/get")
    public ResponseEntity<SignResponse> getUserForAdmin (@RequestParam String account ) throws Exception {
        return new ResponseEntity<>( signService.getMember(account), HttpStatus.OK);
    }

}
