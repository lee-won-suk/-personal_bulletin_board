package com.toffee.nuts.bulletinboard.service;


import com.toffee.nuts.bulletinboard.entity.Board;
import com.toffee.nuts.bulletinboard.entity.Member;
import com.toffee.nuts.bulletinboard.util.BoardUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardUpdateService {
    private final MemberFindService memberFindService;
    private final BoardFindService boardFindService;
    @Transactional
    public Long updateBoard(Long id, Long boardId, BoardUpdateRequest boardUpdateRequest) {
        Member member = memberFindService.findById(id);

        Board board = boardFindService.findById(boardId);
        //checkBoardLoginUser(user, board);
        //TODO
        Long updatedBoardId = board.update(boardUpdateRequest.getTitle(), boardUpdateRequest.getContent(), boardUpdateRequest.getCategory());

        return updatedBoardId;
    }

}
