package com.toffee.nuts.bulletinboard.controller;


import com.toffee.nuts.bulletinboard.entity.BoardEntity;
import com.toffee.nuts.bulletinboard.service.BoardFindService;
import com.toffee.nuts.bulletinboard.util.ApiResult;
import com.toffee.nuts.bulletinboard.util.BoardCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardWriteApi {

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

    @GetMapping("/{boardId}")
    public ApiResult<BoardEntity> findById(@PathVariable Long boardId) {
        try {
            return ApiResult.succeed(boardFindService.findById(boardId));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }



    @GetMapping("/category/{category}")
    public ApiResult<List<BoardEntity>> findByCategory(@PathVariable BoardCategory category) {
        try {
            return ApiResult.succeed(boardFindService.findByCategory(category));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }

}
