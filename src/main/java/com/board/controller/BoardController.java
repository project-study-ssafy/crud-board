package com.board.controller;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.dto.board.BoardDto;
import com.board.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/write")
    public String writeForm() {
        return "board/boardWrite";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Board board, HttpServletRequest request) {
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle(board.getTitle());

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        boardDto.setTitle(title);
        boardDto.setContent(content);

        User user = (User) request.getSession().getAttribute("loginUser");
        boardDto.setUser(user);

        boardService.save(boardDto);
        return "redirect:/";
    }
}