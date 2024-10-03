package com.board.controller;

import com.board.domain.Reply;
import com.board.domain.User;
import com.board.dto.reply.ReplyDto;
import com.board.service.ReplyService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/save")
    public String save(@ModelAttribute Reply reply, HttpServletRequest request) {
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        String content = request.getParameter("content");

        User user = (User) request.getSession().getAttribute("loginUser");

        ReplyDto replyDto = new ReplyDto();

        replyDto.setContent(content);
        replyDto.setUserId(user.getId());
        replyDto.setBoardId(boardId);

        replyService.save(replyDto);

        return "redirect:/detail?id=" + boardId;
    }

    public List<Reply> findAll(int boardId) {
        List<Reply> replies = replyService.findAll(boardId);
        return replies;
    }

}
