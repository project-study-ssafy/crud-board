package com.board.service;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.dto.board.BoardDto;
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

    public Board save(BoardDto boardDto) {
        String title = boardDto.getTitle();
        String content = boardDto.getContent();
        User user = boardDto.getUser();

        Board board = new Board(title, content, user);

        return boardRepository.save(board);
    }

    public void deleteById(int id) {
        boardRepository.deleteById(id);
    }

    public void update(int id, BoardDto boardDto) {
        Board board= (Board) boardRepository.findById(id).orElse(null);

        if (board != null) {
            board.update(boardDto.getTitle(), boardDto.getContent());
        }
    }

}
