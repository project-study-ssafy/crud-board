package com.board.service;

import com.board.domain.Board;
import com.board.domain.Reply;
import com.board.domain.User;
import com.board.dto.reply.ReplyDto;
import com.board.global.exception.board.BoardNotFoundException;
import com.board.global.exception.reply.ReplyNotFoundException;
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

    public void writeReply(ReplyDto replyDto, int boardId, User user) throws BoardNotFoundException {
        Board board = boardRepository.findById(boardId).orElse(null);
        if (board == null) {
            throw new BoardNotFoundException("댓글을 너무 느리게 써서 게시물이 삭제 되었어요");
        }
        replyRepository.save(new Reply(replyDto.getContent(), board, user));
    }

    public void deleteReply(int replyId) throws ReplyNotFoundException {
        Reply reply = replyRepository.findById(replyId).orElse(null);
        if (reply == null) {
            throw new ReplyNotFoundException("댓글이 이미 지워졌어요");
        }
        replyRepository.deleteById(replyId);
    }
}
