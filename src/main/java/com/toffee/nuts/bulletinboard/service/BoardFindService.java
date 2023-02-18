package com.toffee.nuts.bulletinboard.service;


import com.toffee.nuts.bulletinboard.entity.Board;
import com.toffee.nuts.bulletinboard.repository.BoardRepository;
import com.toffee.nuts.bulletinboard.util.BoardCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardFindService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Board findById(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new ExpressionException(String.format("boardEntity is not found")));

        return board;
    }

    @Transactional(readOnly = true)
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Board> findByCategory(BoardCategory category) {
        return boardRepository.findByCategory(category);
    }

  /*  @Transactional(readOnly = true)
    public BoardEntity findByUser(@PathVariable Long userId) {
        BoardEntity boardEntity = boardRepository.findById(userId)
                .orElseThrow(() -> new ExpressionException(String.format("boardEntity is not found")));

        return boardEntity;
    }
*/



}
