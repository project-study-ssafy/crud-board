package com.board.service;

import com.board.domain.Reply;
import com.board.repository.BoardRepository;
import com.board.repository.ReplyRepository;
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

    public List<Reply> findAll(int boardId) {
        return null;
    }

}
