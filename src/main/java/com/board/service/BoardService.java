package com.board.service;

import com.board.domain.Board;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards;
    }
    public Board findById(int id) {
        return boardRepository.findById(id).get();
    }

}
