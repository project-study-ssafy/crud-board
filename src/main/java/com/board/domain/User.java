package com.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nickname", length = 20)
    private String nickname;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "logoinId", length = 30)
    private String loginId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Board> boards;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reply> replies;

}
