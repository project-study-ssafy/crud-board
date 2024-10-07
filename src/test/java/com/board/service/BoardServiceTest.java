package com.board.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
class BoardServiceTest {
  private BoardService boardService;

  @MockBean
  private BoardRepository boardRepository;

  @BeforeEach
  void setUp() {
    boardService = new BoardService(boardRepository);
  }

  @Test
  void 게시판목록출력_성공() {
    Board board1 = new Board("title1", "content1", new User());
    Board board2 = new Board("title2", "content2", new User());
    when(boardRepository.findAll()).thenReturn(Arrays.asList(board1, board2));

    var boards = boardService.findAll();

    assertNotNull(boards);
    assertEquals(2, boards.size());
    assertEquals("title1", boards.get(0).getTitle());
  }

  @Test
  void 게시판목록출력_실패() {
    when(boardRepository.findAll()).thenReturn(Arrays.asList());

    var boards = boardService.findAll();

    assertTrue(boards.isEmpty());
  }
}