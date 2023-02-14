package com.toffee.nuts.bulletinboard.service;


import com.toffee.nuts.bulletinboard.entity.BoardEntity;
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
    public BoardEntity findById(Long boardId) {
        BoardEntity boardEntity = boardRepository.findById(boardId)
                .orElseThrow(() -> new ExpressionException(String.format("boardEntity is not found")));

        return boardEntity;
    }

    @Transactional(readOnly = true)
    public List<BoardEntity> findAll() {
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<BoardEntity> findByCategory(BoardCategory category) {
        return boardRepository.findByCategory(category);
    }






}
