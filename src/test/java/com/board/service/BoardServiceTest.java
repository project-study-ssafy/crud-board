package com.board.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.dto.board.BoardDto;
import com.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.Optional;
import org.mockito.Mockito;
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

  @Test
  void 게시판작성_성공() {
    User user = new User();
    BoardDto boardDto = new BoardDto("New Title", "New Content", user);
    Board savedBoard = new Board("New Title", "New Content", user);
    when(boardRepository.save(any(Board.class))).thenReturn(savedBoard);

    var result = boardService.save(boardDto);

    assertNotNull(result);
    assertEquals("New Title", result.getTitle());
  }

  @Test
  void 게시판작성_실패() {
    User user = new User();
    BoardDto boardDto = new BoardDto("", "", user);

    assertThrows(IllegalArgumentException.class, () -> {
      boardService.save(boardDto);
    });
  }

  @Test
  void 게시판정보조회_성공() {
    Board board = new Board("title1", "content1", new User());
    when(boardRepository.findById(anyInt())).thenReturn(Optional.of(board));

    var result = boardService.findById(1);

    assertNotNull(result);
    assertEquals("title1", result.getTitle());
  }

  @Test
  void 게시판정보조회_실패() {
    when(boardRepository.findById(anyInt())).thenReturn(Optional.empty());

    assertThrows(RuntimeException.class, () -> {
      boardService.findById(999);
    });
  }

  @Test
  void 게시판수정_성공() {
    Board existingBoard = new Board("Old Title", "Old Content", new User());
    BoardDto updateDto = new BoardDto("Updated Title", "Updated Content", new User());
    when(boardRepository.findById(anyInt())).thenReturn(Optional.of(existingBoard));

    boardService.update(1, updateDto);

    assertEquals("Updated Title", existingBoard.getTitle());
    assertEquals("Updated Content", existingBoard.getContent());
  }

  @Test
  void 게시판수정_실패() {
    BoardDto updateDto = new BoardDto("Updated Title", "Updated Content", new User());
    when(boardRepository.findById(anyInt())).thenReturn(Optional.empty());

    assertThrows(RuntimeException.class, () -> {
      boardService.update(999, updateDto);
    });
  }

  @Test
  void 게시판삭제_성공() {
    doNothing().when(boardRepository).deleteById(anyInt());

    boardService.deleteById(1);

    Mockito.verify(boardRepository, Mockito.times(1)).deleteById(1);
  }

  @Test
  void 게시판삭제_실패() {
    doNothing().when(boardRepository).deleteById(anyInt());

    assertDoesNotThrow(() -> boardService.deleteById(999));
  }
}
