package com.board.service;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.board.domain.User;
import com.board.dto.user.SignUpDto;
import com.board.dto.user.UserUpdateDto;
import com.board.global.exception.user.DuplicatedLoginIdException;
import com.board.global.exception.user.DuplicatedNicknameException;
import com.board.global.exception.user.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void 회원가입_성공() {
        SignUpDto user = new SignUpDto();
        user.setLoginId("test");
        user.setPassword("12345678");
        user.setNickname("테스트");

        User signUpUser = userService.signUpProcess(user);

        assertThat(signUpUser).isNotNull();

    }

    @Test
    void 회원가입_실패() {
        SignUpDto user1 = new SignUpDto();
        user1.setLoginId("test");
        user1.setPassword("12345678");
        user1.setNickname("test");

        userService.signUpProcess(user1);

        SignUpDto user2 = new SignUpDto();
        user2.setLoginId("test");
        user2.setPassword("12345678");
        user2.setNickname("test");

        assertThrows(DuplicatedLoginIdException.class, () -> userService.signUpProcess(user2));
    }

    @Test
    void 업데이트_성공() {

        SignUpDto signUp = new SignUpDto();
        signUp.setLoginId("test");
        signUp.setPassword("12345678");
        signUp.setNickname("test");
        User user = userService.signUpProcess(signUp);

        UserUpdateDto update = new UserUpdateDto();
        update.setNickname("newNick");
        update.setPassword("newPassword");

        User updateUser = userService.updateProcess(user.getId(), update);

        assertThat(updateUser.getId()).isEqualTo(user.getId());
        assertThat(updateUser.getNickname()).isEqualTo(update.getNickname());
        assertThat(updateUser.getPassword()).isEqualTo(update.getPassword());
    }

    @Test
    void 업데이트_실패_중복_닉네임() {
        SignUpDto signUp = new SignUpDto();
        signUp.setLoginId("test");
        signUp.setPassword("12345678");
        signUp.setNickname("test");
        userService.signUpProcess(signUp);

        SignUpDto signUp2 = new SignUpDto();
        signUp2.setLoginId("test2");
        signUp2.setPassword("12345678");
        signUp2.setNickname("test2");
        User user2 = userService.signUpProcess(signUp2);

        UserUpdateDto updateDto = new UserUpdateDto();
        updateDto.setNickname("test");
        updateDto.setPassword("newPassword");

        assertThrows(DuplicatedNicknameException.class, () -> userService.updateProcess(
            user2.getId(), updateDto));

    }

    @Test
    void 회원_탈퇴_성공() {
        SignUpDto signUp = new SignUpDto();
        signUp.setLoginId("test");
        signUp.setPassword("12345678");
        signUp.setNickname("test");
        User user = userService.signUpProcess(signUp);

        userService.withdraw(user.getId());

        assertThrows(UserNotFoundException.class, () -> userService.withdraw(user.getId()));
    }

}