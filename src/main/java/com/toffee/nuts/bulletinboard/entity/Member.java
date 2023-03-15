package com.toffee.nuts.bulletinboard.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.toffee.nuts.bulletinboard.util.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MEMBER")
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;




    @JsonManagedReference
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();

    public void writeBoard(Board board) {
        this.boards.add(board); // 사용자의 게시글에 추가한다.
        board.createByUser(this); // 게시글의 작성자를 해당클래스로 설정한다.
    }
}
