package com.toffee.nuts.bulletinboard.repository;

import com.toffee.nuts.bulletinboard.entity.BoardEntity;
import com.toffee.nuts.bulletinboard.util.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    List<BoardEntity> findByCategory(BoardCategory boardCategory);
    //List<BoardEntity> findByUser(User user);
}
