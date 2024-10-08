package com.board.controller;

import com.board.domain.User;
import com.board.dto.reply.ReplyDto;
import com.board.global.exception.board.BoardNotFoundException;
import com.board.global.exception.reply.ReplyNotFoundException;
import com.board.service.ReplyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/write/{boardId}")
    public String writeReply(
            @ModelAttribute @Valid ReplyDto replyDto,
            BindingResult bindingResult,
            @PathVariable int boardId,
            HttpServletRequest request) {

        if(bindingResult.hasErrors()) {
            return "/detail?id=" + boardId;
        }

        User user = (User) request.getSession().getAttribute("loginUser");
        try {
            replyService.writeReply(replyDto, boardId, user);
        } catch (BoardNotFoundException e) {
            return "redirect:/board";
        }
        return "redirect:/detail?id=" + boardId;
    }

    @PostMapping("/delete/{id}")
    public String deleteReply(@PathVariable int id, HttpServletRequest request) {
        int replyId = Integer.parseInt(request.getParameter("replyId"));
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        try {
            replyService.deleteReply(replyId);
        } catch (ReplyNotFoundException e) {
            return "/detail?id=" + boardId;
        }
        return "redirect:/detail?id=" + boardId;
    }
}
