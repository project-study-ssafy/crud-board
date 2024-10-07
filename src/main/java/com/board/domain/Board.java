package com.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Lob
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    private Timestamp createdDate;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"board"})
    @OrderBy("id desc")
    private final List<Reply> replies = new ArrayList<>();

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Board(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Board() {

    }
}