package com.board.service;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.board.domain.User;
import com.board.dto.user.SignUpDto;
import com.board.global.exception.user.DuplicatedLoginIdException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void 회원가입_성공() {
        SignUpDto user = new SignUpDto();
        user.setLoginId("test");
        user.setPassword("1234");
        user.setNickname("테스트");

        User signUpUser = userService.signUpProcess(user);

        assertThat(signUpUser).isNotNull();

    }

    @Test
    void 회원가입_실패() {
        SignUpDto user1 = new SignUpDto();
        user1.setLoginId("test");
        user1.setPassword("1234");
        user1.setNickname("test");

        userService.signUpProcess(user1);

        SignUpDto user2 = new SignUpDto();
        user2.setLoginId("test");
        user2.setPassword("1234");
        user2.setNickname("test");

        assertThrows(DuplicatedLoginIdException.class, () -> userService.signUpProcess(user2));
    }

}