package com.board.dto.reply;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDto {
    private int id;
    private int boardId;
    private int userId;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    public ReplyDto() {}

    public ReplyDto(int boardId, int userId, String content) {
    }
}
