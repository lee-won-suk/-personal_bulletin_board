package com.toffee.nuts.bulletinboard.repository;

import com.toffee.nuts.bulletinboard.entity.Board;
import com.toffee.nuts.bulletinboard.util.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByCategory(BoardCategory category);


    //List<BoardEntity> findByUser(User user);
}
