package com.board.controller;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.dto.board.BoardDto;
import com.board.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/")
    public String findAll(Model model) {
        List<Board> boards = boardService.findAll();

        model.addAttribute("boards", boards);

        return "board/boardList";
    }

    @GetMapping("/detail")
    public String findById(@RequestParam("id") int id, Model model) {
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/boardDetail";
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

    @PostMapping("/delete/{id}")
    public String deleteBoard(@PathVariable int id) {
        boardService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam int id, Model model) {
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/boardUpdate";
    }

    @PostMapping("/updateBoard")
    public String update(@ModelAttribute Board board, HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        BoardDto boardDto = new BoardDto();

        boardDto.setId(id);
        boardDto.setTitle(board.getTitle());

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        boardDto.setTitle(title);
        boardDto.setContent(content);

        User user = (User) request.getSession().getAttribute("loginUser");
        boardDto.setUser(user);

        boardService.update(boardDto.getId(), boardDto);

        return "redirect:/detail?id=" + id;
    }

}
