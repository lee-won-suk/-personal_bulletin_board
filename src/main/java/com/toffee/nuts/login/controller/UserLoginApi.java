package com.toffee.nuts.login.controller;


import com.toffee.nuts.bulletinboard.service.BoardDeleteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user/login")
@RequiredArgsConstructor
public class UserLoginApi {

    private final BoardDeleteService boardDeleteService;



    @PostMapping("/{userid}/{boardId}")
    public void updateBoard(@PathVariable Long userId, @PathVariable Long boardId) {
       boardDeleteService.deleteBoardById(userId, boardId);
    }
}
