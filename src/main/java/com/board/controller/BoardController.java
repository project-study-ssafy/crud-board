package com.board.controller;

import com.board.domain.Board;
import com.board.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String searchAll(Model model) {
        List<Board> boards = boardService.findAll();

        model.addAttribute("boards", boards);

        return "home";
    }
}