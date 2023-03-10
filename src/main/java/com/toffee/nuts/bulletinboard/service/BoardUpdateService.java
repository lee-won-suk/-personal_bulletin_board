package com.toffee.nuts.bulletinboard.service;


import com.toffee.nuts.bulletinboard.entity.Board;
import com.toffee.nuts.bulletinboard.entity.User;
import com.toffee.nuts.bulletinboard.repository.BoardRepository;
import com.toffee.nuts.bulletinboard.util.BoardUpdateRequest;
import com.toffee.nuts.bulletinboard.util.BoardWriteRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardUpdateService {
    private final UserFindService userFindService;
    private final BoardFindService boardFindService;
    @Transactional
    public Long updateBoard(Long userId, Long boardId, BoardUpdateRequest boardUpdateRequest) {
        User user = userFindService.findById(userId);

        Board board = boardFindService.findById(boardId);
        //checkBoardLoginUser(user, board);
        //TODO
        Long updatedBoardId = board.update(boardUpdateRequest.getTitle(), boardUpdateRequest.getContent(), boardUpdateRequest.getCategory());

        return updatedBoardId;
    }

}
