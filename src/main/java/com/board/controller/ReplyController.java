package com.board.controller;

import com.board.domain.User;
import com.board.dto.reply.ReplyDto;
import com.board.service.ReplyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/write")
    public String writeReply(@ModelAttribute @Valid ReplyDto replyDto, BindingResult bindingResult, HttpServletRequest request) {
        int boardId = Integer.parseInt(request.getParameter("boardId"));

        User user = (User) request.getSession().getAttribute("loginUser");

        replyService.writeReply(replyDto, boardId, user);

        return "redirect:/detail?id=" + boardId;
    }
}
