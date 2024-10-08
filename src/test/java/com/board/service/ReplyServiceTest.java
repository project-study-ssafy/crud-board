package com.board.service;

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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

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
        ReplyDto replyDto = new ReplyDto();
        replyDto.setContent("댓글내용");
        Board board = new Board();
        User user = new User();
        when(boardRepository.findById(anyInt())).thenReturn(Optional.of(board));

        assertDoesNotThrow(() -> replyService.writeReply(replyDto, board.getId(), user));

        verify(replyRepository, times(1)).save(any(Reply.class));
    }

    @Test
    void 댓글작성_실패() {
        ReplyDto replyDto = new ReplyDto();
        replyDto.setContent("");
        when(boardRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> replyService.writeReply(replyDto, 99999, null));

        verify(replyRepository, never()).save(any(Reply.class));
    }
}
