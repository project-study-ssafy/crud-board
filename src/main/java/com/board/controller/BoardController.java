package com.board.controller;

import com.board.domain.Board;
import com.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/")
    public String findAll(Model model) {
        List<Board> boards = boardService.findAll();

        model.addAttribute("boards", boards);

        return "board/boardList";
    }

    @GetMapping("/boardDetail")
    public String findById(@RequestParam("id") int id, Model model) {
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/boardDetail";
    }

}
