package com.board.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import com.board.domain.Board;
import com.board.domain.Reply;
import com.board.domain.User;
import com.board.dto.reply.ReplyDto;
import com.board.repository.BoardRepository;
import com.board.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
@Transactional
class ReplyServiceTest {

    @Autowired
    private ReplyService replyService;

    @MockBean
    private ReplyRepository replyRepository;

    @MockBean
    private BoardRepository boardRepository;


    @BeforeEach
    void setUp() {

    }

    @Test
    void 댓글작성_성공() {
        ReplyDto replyDto = new ReplyDto(1, 1, "댓글 내용");
        Board board = new Board("아으아으", "으아으아", new User("1", "1", "1"));

        when(boardRepository.findById(anyInt())).thenReturn(Optional.of(board));

        assertDoesNotThrow(() -> replyService.save(replyDto));

        verify(replyRepository, times(1)).save(any(Reply.class));
    }

    @Test
    void 댓글작성_실패() {
        ReplyDto replyDto = new ReplyDto(1, 1, "");

        when(boardRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> replyService.save(replyDto));

        verify(replyRepository, never()).save(any(Reply.class));
    }

    @Test
    void 댓글삭제_성공() {
        int replyId = 1;

        doNothing().when(replyRepository).deleteById(anyInt());

        assertDoesNotThrow(() -> replyService.delete(replyId));

        verify(replyRepository, times(1)).deleteById(replyId);
    }

    @Test
    void 댓글삭제_실패() {
        int replyId = 999;

        doThrow(new RuntimeException("Reply not found")).when(replyRepository).deleteById(replyId);

        assertThrows(RuntimeException.class, () -> replyService.delete(replyId));

        verify(replyRepository, times(1)).deleteById(replyId);
    }
}