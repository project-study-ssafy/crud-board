package com.board.controller;

import com.board.domain.User;
import com.board.dto.user.SignUpDto;
import com.board.dto.user.UserUpdateDto;
import com.board.global.exception.user.DuplicatedLoginIdException;
import com.board.global.exception.user.DuplicatedNicknameException;
import com.board.global.exception.user.UserNotFoundException;
import com.board.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
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
            return "user/signUpForm";
        }
        User loginUser;
        try {
            loginUser = userService.signUpProcess(signUpDto);
        } catch (DuplicatedLoginIdException e) {
            bindingResult.rejectValue("loginId", "loginId.duplicated", "중복된 id 입니다.");
            return "user/signUpForm";
        } catch (DuplicatedNicknameException e) {
            bindingResult.rejectValue("nickname", "nickname.duplicated", "중복된 닉네임 입니다.");
            return "user/signUpForm";
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", loginUser);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable int id, Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null) {
            return "redirect:/";
        }
        if (user.getId() != id) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "user/updateForm";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id,
        @Validated @ModelAttribute UserUpdateDto userUpdateDto,
        BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "user/updateForm";
        }

        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser.getId() != id) {
            bindingResult.reject("id.notMatch", "잘못된 요청입니다");
            return "user/updateForm";
        }

        try {
            userService.updateProcess(id, userUpdateDto);
        } catch (DuplicatedLoginIdException e) {
            bindingResult.reject("id.notfound", "사용자를 찾을 수 없습니다.");
            return "user/updateForm";
        } catch (DuplicatedNicknameException e) {
            bindingResult.rejectValue("nickname", "nickname.duplicated", "중복된 닉네입 입니다.");
            return "user/updateForm";
        }
        session.setAttribute("loginUser", loginUser);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detailForm(@PathVariable("id") int id, Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null) {
            return "redirect:/";
        }
        if (user.getId() != id) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "user/detailForm";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null) {
            return "redirect:/";
        }
        if (user.getId() != id) {
            return "redirect:/";
        }
        try {
            userService.withdraw(id);
        } catch (UserNotFoundException e) {
            log.error(e.getMessage());
            return "redirect:/";
        }
        request.getSession().removeAttribute("loginUser");
        return "redirect:/";
    }
}
