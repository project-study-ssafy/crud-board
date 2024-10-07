package com.board.dto.board;

import com.board.domain.Reply;
import com.board.domain.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BoardDto {
  private int id;

  @NotBlank(message = "제목을 입력해주세요")
  private String title;
  @NotBlank(message = "내용을 입력해주세요")
  private String content;

  private User user;
  private Timestamp createdDate;
  private List<Reply> replyList = new ArrayList<>();

  public BoardDto() {}

  public BoardDto(String newTitle, String newContent, User user) {
    this.title = newTitle;
    this.content = newContent;
    this.user = user;
  }
}