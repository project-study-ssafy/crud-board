package com.board.service;

import com.board.domain.Board;
import com.board.domain.Reply;
import com.board.domain.User;
import com.board.dto.reply.ReplyDto;
import com.board.repository.BoardRepository;
import com.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    public void writeReply(ReplyDto replyDto, int boardId, User user) {
        Board board = boardRepository.findById(boardId).get();
        replyRepository.save(new Reply(replyDto.getContent(), board, user));
    }
}
