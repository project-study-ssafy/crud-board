package com.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "\"USER\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nickname", length = 10)
    private String nickname;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "logoinId", length = 20)
    private String loginId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Board> boards;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reply> replies;

    public User(String nickname, String password, String loginId) {
        this.nickname = nickname;
        this.password = password;
        this.loginId = loginId;
    }

}
