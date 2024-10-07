package com.board.service;

import com.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
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

}