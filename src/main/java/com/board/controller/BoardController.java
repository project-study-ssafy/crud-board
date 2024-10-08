package com.board.controller;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.dto.board.BoardDto;
import com.board.global.exception.board.BoardNotFoundException;
import com.board.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/detail")
    public String detailBoard(@RequestParam("id") int id, Model model) {
        try {
            Board board = boardService.detailBoard(id);
            model.addAttribute("board", board);
        } catch (BoardNotFoundException e) {
            return "redirect:/";
        }
        return "board/boardDetail";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "board/boardWrite";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute @Valid BoardDto boardDto, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "board/boardWrite";
        }

        User user = (User) request.getSession().getAttribute("loginUser");
        boardService.writeBoard(boardDto, user);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam int id, Model model) {
        try {
            Board board = boardService.detailBoard(id);
            model.addAttribute("board", board);
            return "board/boardUpdate";
        } catch (BoardNotFoundException e) {
            return "redirect:/";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDto boardDto, HttpServletRequest request) {
        try {
            boardService.update(boardDto);

            int id = Integer.parseInt(request.getParameter("id"));
            return "redirect:/detail?id=" + id;
        } catch (BoardNotFoundException e) {
            return "redirect:/";
        }
    }
}