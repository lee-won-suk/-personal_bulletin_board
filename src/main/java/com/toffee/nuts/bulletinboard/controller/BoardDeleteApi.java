package com.toffee.nuts.bulletinboard.controller;


import com.toffee.nuts.bulletinboard.service.BoardDeleteService;
import com.toffee.nuts.bulletinboard.service.BoardUpdateService;
import com.toffee.nuts.bulletinboard.util.ApiResult;
import com.toffee.nuts.bulletinboard.util.BoardUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/boards/delete")
@RequiredArgsConstructor
public class BoardDeleteApi {

    private final BoardDeleteService boardDeleteService;



    @PostMapping("/{id}/{boardId}")
    public void updateBoard(@PathVariable Long id, @PathVariable Long boardId) {
       boardDeleteService.deleteBoardById(id, boardId);
    }
}
