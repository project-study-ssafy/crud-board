package com.board.controller;

import com.board.domain.Board;
import com.board.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/")
    public String findAll(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Board> boards = boardService.findAll();

        model.addAttribute("boards", boards);

        return "board/board-list";
    }

}
