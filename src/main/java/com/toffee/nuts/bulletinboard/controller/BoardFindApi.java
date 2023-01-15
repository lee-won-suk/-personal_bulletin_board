package com.toffee.nuts.bulletinboard.controller;


import com.toffee.nuts.bulletinboard.entity.BoardEntity;
import com.toffee.nuts.bulletinboard.util.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardFindApi {

    private final BoardFindService boardFindService;

    @GetMapping()
    public ApiResult<List<BoardEntity>> findAll() {
        try {
            return ApiResult.succeed(boardFindService.findAll());
        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }

}
