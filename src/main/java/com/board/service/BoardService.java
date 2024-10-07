package com.board.service;

import com.board.domain.Board;
import com.board.repository.BoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  public List<Board> findAll() {
    List<Board> boards = boardRepository.findAll();
    return boards;
  }
}
