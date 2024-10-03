package com.board.service;

import com.board.domain.Board;
import com.board.domain.Reply;
import com.board.domain.User;
import com.board.dto.reply.ReplyDto;
import com.board.repository.BoardRepository;
import com.board.repository.ReplyRepository;
import com.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository repository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public List<Reply> findAll(int boardId) {
        return null;
    }

    public void save(ReplyDto replyDto) {
        String content = replyDto.getContent();
        int boardId = replyDto.getBoardId();
        int userId = replyDto.getUserId();

        User user = userRepository.findById(userId).get();
        Board board = boardRepository.findById(boardId).get();

        Reply reply = new Reply(content, board, user);
        repository.save(reply);
    }


}
