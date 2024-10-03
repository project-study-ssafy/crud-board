package com.board.dto.board;

import com.board.domain.Reply;
import com.board.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class BoardDto {
    private int id;
    private String title;
    private String content;
    private User user;
    private Timestamp createdDate;
    private List<Reply> replyList = new ArrayList<>();
}
