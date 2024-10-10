package com.board.service;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.dto.board.BoardDto;
import com.board.global.exception.board.BoardNotFoundException;
import com.board.repository.BoardRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

  @Transactional(readOnly = true)
  public Page<Board> getPagedBoards(Pageable pageable) {
    return boardRepository.findAll(pageable); // 리포지토리를 통해 데이터 조회
  }

  @Transactional(readOnly = true)
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

  public void update(BoardDto boardDto) throws BoardNotFoundException {
    int id = boardDto.getId();
    Board board = boardRepository.findById(id).orElse(null);

    if (board == null) {
      throw new BoardNotFoundException("그런 게시물 없음");
    }

    board.update(boardDto.getTitle(), boardDto.getContent());
  }
}
