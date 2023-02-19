package com.toffee.nuts.bulletinboard.service;


import com.toffee.nuts.bulletinboard.entity.Board;
import com.toffee.nuts.bulletinboard.entity.User;
import com.toffee.nuts.bulletinboard.repository.BoardRepository;
import com.toffee.nuts.bulletinboard.util.BoardUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardDeleteService {
    private final UserFindService userFindService;
    private final BoardFindService boardFindService;

    private final BoardRepository boardRepository;

    @Transactional
    public void deleteBoardById(Long userId, Long boardId) {
        User user = userFindService.findById(userId);
        Board board = boardFindService.findById(boardId);
        //checkBoardLoginUser(user, board);
        boardRepository.deleteById(boardId);

    }
}
