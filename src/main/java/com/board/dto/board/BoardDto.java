package com.board.dto.board;

import com.board.domain.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
  private int id;

  @NotBlank(message = "제목을 입력해주세요")
  private String title;

  @NotBlank(message = "내용을 입력해주세요")
  private String content;

  public BoardDto() {}

  public BoardDto(String newTitle, String newContent) {
    this.title = newTitle;
    this.content = newContent;
  }
}