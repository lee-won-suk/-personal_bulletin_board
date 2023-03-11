package com.toffee.nuts.bulletinboard.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.toffee.nuts.bulletinboard.util.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;


    @Column(name = "device_token")
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
