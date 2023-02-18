package com.toffee.nuts.bulletinboard.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.toffee.nuts.bulletinboard.util.BoardCategory;
import com.toffee.nuts.bulletinboard.util.BoardEntityConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @Column(name = "board_id")
    private Long board_id;

    @Column(name = "title")
    private String title;

    @Column(name = "board_content")
    private String content;

    @Column(name = "writer")
    private String writer;

    @Convert(converter = BoardEntityConverter.class)
    private BoardCategory category;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id")
    private User user;

    @Builder
    public Board(String title, String writer, String content, BoardCategory category) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.category = category;
    }

    public void createByUser(User user) {
        this.user = user;
    }
}
