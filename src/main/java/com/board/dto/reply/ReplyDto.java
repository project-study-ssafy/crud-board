package com.board.dto.reply;

import com.board.domain.Board;
import com.board.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDto {
    private int id;
    private int boardId;
    private int userId;
    private String content;

    public ReplyDto() {}

    public ReplyDto(int boardId, int userId, String content) {
        this.boardId = boardId;
        this.userId = userId;
        this.content = content;
    }
}
