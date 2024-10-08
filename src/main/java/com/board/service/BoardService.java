package com.board.service;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.dto.board.BoardDto;
import com.board.global.exception.board.BoardNotFoundException;
import com.board.repository.BoardRepository;
import java.util.List;
import java.util.Optional;

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

  public Board detailBoard(int id) throws BoardNotFoundException {
    Board board = boardRepository.findById(id).orElse(null);
    if (board == null) {
      throw new BoardNotFoundException("그런 게시물 없어요");
    }
    return board;
  }

  public Board writeBoard(BoardDto boardDto, User user) {
    String title = boardDto.getTitle();
    String content = boardDto.getContent();

    Board board = new Board(title, content, user);

    return boardRepository.save(board);
  }

  public void deleteBoard(int id) {
    boardRepository.deleteById(id);
  }

}
