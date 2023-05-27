package com.toffee.nuts.bulletinboard.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.toffee.nuts.bulletinboard.util.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
@Getter
@Builder @AllArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String account; // 아이디 계정 명

    private String nickname;// 닉네임

    private String username;

    private String password;

    @Column(unique = true)
    private String email; //이메일

/*    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;*/

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    private List<Authority> roles = new ArrayList<>();


    public void setRoles(List<Authority> role) {
        this.roles = role;
        role.forEach(o -> o.setMember(this));
    }



    @JsonManagedReference
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();

    public void writeBoard(Board board) {
        this.boards.add(board); // 사용자의 게시글에 추가한다.
        board.createByUser(this); // 게시글의 작성자를 해당클래스로 설정한다.
    }
}
