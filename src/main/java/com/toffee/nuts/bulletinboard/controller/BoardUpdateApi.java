package com.toffee.nuts.bulletinboard.controller;


import com.toffee.nuts.bulletinboard.service.BoardUpdateService;
import com.toffee.nuts.bulletinboard.service.BoardWriteService;
import com.toffee.nuts.bulletinboard.util.ApiResult;
import com.toffee.nuts.bulletinboard.util.BoardUpdateRequest;
import com.toffee.nuts.bulletinboard.util.BoardWriteRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/boards/update")
@RequiredArgsConstructor
public class BoardUpdateApi {

    private final BoardUpdateService boardUpdateService;



    @PostMapping("/{userid}/{boardId}")
    public ApiResult<Long> updateBoard(@PathVariable Long userId, @PathVariable Long boardId, @RequestBody BoardUpdateRequest boardUpdateRequest) {
        try {
            return ApiResult.succeed(boardUpdateService.updateBoard(userId, boardId, boardUpdateRequest));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }
}
