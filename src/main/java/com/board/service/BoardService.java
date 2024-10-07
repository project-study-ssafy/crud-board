package com.board.service;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.dto.board.BoardDto;
import com.board.repository.BoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  @Transactional(readOnly = true)
  public List<Board> findAll() {
    List<Board> boards = boardRepository.findAll();
    return boards;
  }

  public Board save(BoardDto boardDto) {
    String title = boardDto.getTitle();
    String content = boardDto.getContent();
    User user = boardDto.getUser();

    Board board = new Board(title, content, user);

    return boardRepository.save(board);
  }
}
