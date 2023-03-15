package com.toffee.nuts.bulletinboard.service;


import com.toffee.nuts.bulletinboard.entity.Board;
import com.toffee.nuts.bulletinboard.entity.Member;

import com.toffee.nuts.bulletinboard.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardDeleteService {
    private final MemberFindService memberFindService;
    private final BoardFindService boardFindService;

    private final BoardRepository boardRepository;

    @Transactional
    public void deleteBoardById(Long userId, Long boardId) {
        Member member = memberFindService.findById(userId);
        Board board = boardFindService.findById(boardId);
        //checkBoardLoginUser(user, board);
        boardRepository.deleteById(boardId);

    }
}
