/*
package com.toffee.nuts.bulletinboard.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.toffee.nuts.bulletinboard.util.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String email;


    private String password;


    private String username;


    private String deviceToken;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;




    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();

    public void writeBoard(Board board) {
        this.boards.add(board); // 사용자의 게시글에 추가한다.
        board.createByUser(this); // 게시글의 작성자를 해당클래스로 설정한다.
    }
}
*/
