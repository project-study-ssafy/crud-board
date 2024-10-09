package com.board.controller;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.dto.board.BoardDto;
import com.board.global.exception.board.BoardNotFoundException;
import com.board.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public String getBoards(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "desc") String sortOrder, Model model) {
      Pageable pageable;
      
      //sortOrder에 따라서 정렬 순서 교체가 가능하면 좋을 것 같다.
      if (sortOrder.equals("desc")) pageable = PageRequest.of(page - 1, 10, Sort.by("id").descending());
      else pageable = PageRequest.of(page - 1, 10, Sort.by("id").ascending());

      Page<Board> boards = boardService.getPagedBoards(pageable);
      model.addAttribute("boards", boards);

      //버튼이 하나만 있으면 좋을 것 같다.
      model.addAttribute("sortOrder", sortOrder);

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
    public String update(@ModelAttribute @Valid BoardDto boardDto, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "board/boardUpdate";
        }

        try {
            boardService.update(boardDto);

            int id = Integer.parseInt(request.getParameter("id"));
            return "redirect:/detail?id=" + id;
        } catch (BoardNotFoundException e) {
            return "redirect:/";
        }
    }
}