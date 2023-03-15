package com.toffee.nuts.bulletinboard.controller;


import com.toffee.nuts.bulletinboard.service.BoardWriteService;
import com.toffee.nuts.bulletinboard.util.ApiResult;
import com.toffee.nuts.bulletinboard.util.BoardWriteRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardWriteApi {

    private final BoardWriteService boardWriteService;

    @PostMapping("/{userid}/write")
    public ApiResult<Long> writeBoard(@PathVariable Long id, @RequestBody BoardWriteRequest boardWriteRequest) {
        try {
            Long boardId = boardWriteService.writeBoard(id, boardWriteRequest);
            return ApiResult.succeed(boardId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }


}
