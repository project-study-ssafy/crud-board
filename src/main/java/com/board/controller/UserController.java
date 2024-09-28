package com.board.controller;

import com.board.domain.User;
import com.board.dto.user.SignUpDto;
import com.board.global.exception.user.DuplicatedLoginIdException;
import com.board.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/sign-up")
    public String signUpForm() {
        return "user/signUpForm";
    }

    @PostMapping("/sign-up")
    public String signUp(@Validated @ModelAttribute SignUpDto signUpDto,
        BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "user/signUp";
        }

        User loginUser;
        try {
            loginUser = userService.signUpProcess(signUpDto);
        } catch (DuplicatedLoginIdException e) {
            bindingResult.reject("loginId.duplicated", "중복된 id 입니다.");
            return "user/signUp";
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginUser);
        return "redirect:/";
    }
}
