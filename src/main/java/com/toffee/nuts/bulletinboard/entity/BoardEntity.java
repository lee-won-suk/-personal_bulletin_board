package com.toffee.nuts.bulletinboard.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardEntity {

    @Id
    @Column(name = "board_id")
    private Long board_id;

    @Column(name = "title")
    private Long title;

    @Column(name = "board_content")
    private Long board_content;

    @Column(name = "writer")
    private Long writer;

    private BoardCategory

    @Column(name = "board_id")
    private User user;

}
